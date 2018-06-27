package io.tohure.jetpacktest.ui.user

import androidx.work.Worker

class UserWorker : Worker() {

    override fun doWork(): Result {
        return if (/*uploadDataUser()*/1 + 1 > 1) {
            Result.SUCCESS
        } else {
            Result.FAILURE
        }
    }

}
