package io.tohure.jetpacktest.ui.next

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.tohure.jetpacktest.R
import android.support.text.emoji.EmojiCompat
import kotlinx.android.synthetic.main.fragment_next.*

class NextFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val processed = EmojiCompat.get().process("" +
                "\uD83C\uDF89 " +
                "\uD83D\uDE0E " +
                "\uD83D\uDE0E " +
                "\uD83D\uDE4C" +
                "\uD83D\uDCAA" +
                "\uD83C\uDF8A ")
        etvThinking.text = processed*/
    }
}
