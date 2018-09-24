package io.tohure.jetpacktest.ui.user

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class UserWorker(
        context: Context,
        params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return if (/*uploadDataUser()*/1 + 1 > 1) {
            Result.SUCCESS
        } else {
            Result.FAILURE
        }
    }

}
