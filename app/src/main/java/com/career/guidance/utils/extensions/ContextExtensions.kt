package com.career.guidance.utils.extensions

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import java.util.*

fun Context.getLocationManager() = getSystemService(Context.LOCATION_SERVICE) as LocationManager

fun Context.getConnectivityManager() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


inline fun <reified T : Any> Context.launchActivity(options: Bundle? = null, noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent, options)
}

fun Context.startApp(pName: String) {
    if (isAppInstalled(pName)) startActivity(packageManager.getLaunchIntentForPackage(pName))
}

/**
 * Check if an App is Installed on the user device.
 */
fun Context.isAppInstalled(packageName: String): Boolean {
    return try {
        packageManager.getApplicationInfo(packageName, 0)
        true
    } catch (ignore: Exception) {
        false
    }
}

@Throws(PackageManager.NameNotFoundException::class)
fun Context.getAppVersionName(pName: String = packageName): String = packageManager.getPackageInfo(pName, 0).versionName

@Throws(PackageManager.NameNotFoundException::class)
fun Context.getAppVersionCode(pName: String = packageName): Int = packageManager.getPackageInfo(pName, 0).versionCode

fun Context.dialNumber(number: String) = startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")))

fun Context.sendEmail(mailID: String) = startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$mailID")))



fun Context.isPermissionGranted(permissions: Array<String>): Boolean {
    permissions.forEach {
        if (ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED)
            return false
    }
    return true
}