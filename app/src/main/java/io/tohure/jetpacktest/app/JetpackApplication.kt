package io.tohure.jetpacktest.app

import android.app.Application
import android.util.Log
import androidx.annotation.Nullable
import androidx.core.provider.FontRequest
import androidx.emoji.text.EmojiCompat
import androidx.emoji.text.FontRequestEmojiCompatConfig
import io.tohure.jetpacktest.R


class JetpackApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val config: EmojiCompat.Config

        val fontRequest = FontRequest(
                "com.google.android.gms.fonts",
                "com.google.android.gms",
                "Noto Color Emoji Compat",
                R.array.com_google_android_gms_fonts_certs)

        config = FontRequestEmojiCompatConfig(applicationContext, fontRequest)
                .setReplaceAll(true)
                .registerInitCallback(object : EmojiCompat.InitCallback() {
                    override fun onInitialized() {
                        Log.i("thr", "EmojiCompat initialized")
                    }

                    override fun onFailed(@Nullable throwable: Throwable?) {
                        Log.e("thr", "EmojiCompat initialization failed", throwable)
                    }
                })

        EmojiCompat.init(config)

    }
}