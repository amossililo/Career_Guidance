package com.career.guidance

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.career.guidance.util.Constants
import com.career.guidance.utils.extensions.getSharedPrefInstance
import com.career.guidance.utils.extensions.launchActivity
import com.career.guidance.utils.extensions.runDelayed
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private  val TAG = "SplashAcitivity"
    @SuppressLint("PackageManagerGetSignatures")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        try {
            val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Log.d("KeyHash:", Base64.getEncoder().encodeToString(md.digest()))
                }
            }
        } catch (e: PackageManager.NameNotFoundException) {
        } catch (e: NoSuchAlgorithmException) { }
        runDelayed(1000) {

            launchActivity<MainActivity>()
            finish()
        }
    }


}