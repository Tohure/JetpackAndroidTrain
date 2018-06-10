package io.tohure.jetpacktest.ui.user

import androidx.work.Worker

class UserWorker : Worker() {
    override fun doWork(): WorkerResult {

        return if (/*uploadDataUser()*/1 + 1 > 1) {
            WorkerResult.SUCCESS
        } else {
            WorkerResult.FAILURE
        }

    }

}
