package io.tohure.jetpacktest.app

import android.app.Application
import android.support.text.emoji.EmojiCompat
import android.support.text.emoji.FontRequestEmojiCompatConfig
import android.R.array
import android.support.annotation.Nullable
import android.support.v4.provider.FontRequest
import android.util.Log
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