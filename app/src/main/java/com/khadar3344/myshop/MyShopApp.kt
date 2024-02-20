package com.khadar3344.myshop

import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerLib
import com.appsflyer.attribution.AppsFlyerRequestListener
import dagger.hilt.android.HiltAndroidApp

const val LOG_TAG = "appsflyer"
@HiltAndroidApp
class MyShopApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // AppsFlyer Initialization (with a sample conversion listener)
        // Initialize AppsFlyer SDK
        AppsFlyerLib.getInstance().init("F88pAegwy4moVzhKKspqHF", null, this)
        AppsFlyerLib.getInstance().setDebugLog(true)
        AppsFlyerLib.getInstance().start(
            this, "F88pAegwy4moVzhKKspqHF",
            object : AppsFlyerRequestListener {
                override fun onSuccess() {
                    Log.d(LOG_TAG, "Launch sent successfully")
                }

                override fun onError(errorCode: Int, errorDesc: String) {
                    Log.d(
                        LOG_TAG,
                        "Launch failed to be sent:\n" +
                                "Error code: " + errorCode + "\n"
                                + "Error description: " + errorDesc,
                    )
                }
            },
        )
    }
}