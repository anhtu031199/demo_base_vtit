package com.tuna.nothingapp.utils.timber

import timber.log.Timber

class CrashlyticsTree : Timber.Tree() {
    companion object {
        private const val CRASHLYTICS_KEY_PRIORITY = "priority"
        private const val CRASHLYTICS_KEY_TAG = "tag"
        private const val CRASHLYTICS_KEY_MESSAGE = "message"
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        // Only send the error logs to Firebase Crashlytics
//        if (priority == Log.ERROR) {
//            Crashlytics.setInt(CRASHLYTICS_KEY_PRIORITY, priority)
//            Crashlytics.setString(CRASHLYTICS_KEY_TAG, tag)
//            Crashlytics.setString(CRASHLYTICS_KEY_MESSAGE, message)
//
//            if (throwable == null) {
//                Crashlytics.logException(Exception(message))
//            } else {
//                Crashlytics.logException(throwable)
//            }
//        }
    }
}
