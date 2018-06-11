package io.tohure.jetpacktest.ui.user

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.content.Context
import android.arch.lifecycle.OnLifecycleEvent

class UserLocationListener(
        val context: Context,
        val lifecycle: Lifecycle,
        val callback: (Any) -> Unit) : LifecycleObserver {

    var enabled = false

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        if (enabled) {
            // connect service
        }
    }

    fun enable() {
        enabled = true
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        // disconnect if connected the service
    }
}