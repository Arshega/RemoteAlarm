package com.example.pc.remotealarm

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import kotlin.math.log

class MYFirebaseInstanceId: FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        var token: String = FirebaseInstanceId.getInstance().getToken().toString()
        Log.d("TOKEN", token)
    }
}