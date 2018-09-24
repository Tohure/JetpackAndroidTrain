package io.tohure.jetpacktest.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import io.tohure.jetpacktest.R
import kotlinx.android.synthetic.main.user_fragment.*

class UserFragment : Fragment() {

    private lateinit var viewModel: UserViewModel
    private lateinit var userLocationListener: UserLocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //LifecycleObserver && LifecycleOwner
        userLocationListener = UserLocationListener(context!!, lifecycle) { location ->
            // update UI or make something
            location.toString()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //ViewModel
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        viewModel.init("Tohure")

        //LiveData
        viewModel.data.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()

            //LifecycleObserver
            userLocationListener.enable()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Navigation
        btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_nextFragment)
        }

        //Worker
        val rules = Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

        val userWork = OneTimeWorkRequest.Builder(UserWorker::class.java)
                .setConstraints(rules)
                .build()

        WorkManager
                .getInstance()
                .enqueue(userWork)

        WorkManager
                .getInstance()
                .getStatusById(userWork.id)
                .observe(this, Observer { workStatus ->
                    // Do something with the status
                    if (workStatus != null && workStatus.state.isFinished) {
                        // ...
                    }
                })
    }
}
