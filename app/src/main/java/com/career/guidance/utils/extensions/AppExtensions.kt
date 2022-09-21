package com.career.guidance.utils.extensions

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.career.guidance.GuidanceApp
import com.career.guidance.GuidanceApp.Companion.getAppInstance
import com.career.guidance.GuidanceApp.Companion.noInternetDialog
import com.career.guidance.R
import com.career.guidance.util.Constants.PLAY_STORE_URL_PREFIX
import com.career.guidance.utils.SharedPrefUtils
import kotlinx.android.synthetic.main.dialog_no_internet.*


/**
 * Add shared preference related to user session here
 */

fun shareMyApp(context: Context, subject: String, message: String) {
    try {
        val appUrl = PLAY_STORE_URL_PREFIX + context.packageName
        val i = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_SUBJECT, subject)
        var leadingText = "\n" + message + "\n\n"
        leadingText += appUrl + "\n\n"
        i.putExtra(Intent.EXTRA_TEXT, leadingText)
        context.startActivity(Intent.createChooser(i, "Share using"))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun shareStoreLink(context: Context, subject: String, message: String, link: String) {
    try {

        val i = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_SUBJECT, subject)
        var leadingText = "\n" + message + "\n\n"
        leadingText += link + "\n\n"
        i.putExtra(Intent.EXTRA_TEXT, leadingText)
        context.startActivity(Intent.createChooser(i, "Share using"))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun getSharedPrefInstance(): SharedPrefUtils {

    return if (GuidanceApp.sharedPrefUtils == null) {
        GuidanceApp.sharedPrefUtils = SharedPrefUtils()
        GuidanceApp.sharedPrefUtils!!
    } else {
        GuidanceApp.sharedPrefUtils!!
    }
}

fun Context.fontMedium(): Typeface? {
    return Typeface.createFromAsset(assets, getString(R.string.font_bold))
}

fun Context.fontSemiBold(): Typeface? {
    return Typeface.createFromAsset(assets, getString(R.string.font_medium))
}

fun Context.fontBold(): Typeface? {
    return Typeface.createFromAsset(assets, getString(R.string.font_semibold))

}

fun ImageView.loadImageFromDrawable(@DrawableRes aPlaceHolderImage: Int) {

    Glide.with(getAppInstance()).load(aPlaceHolderImage).diskCacheStrategy(DiskCacheStrategy.NONE)
        .into(this)
}

fun ImageView.loadImageFromUri(url: String){
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.placeholder)
        .into(this)

}

fun Context.openCustomTab(url: String) =
    CustomTabsIntent.Builder().build().launchUrl(this, Uri.parse(url))

fun Activity.getAlertDialog(
    aMsgText: String,
    aTitleText: String = getString(R.string.lbl_dialog_title),
    aPositiveText: String = getString(R.string.lbl_yes),
    aNegativeText: String = getString(R.string.lbl_no),
    onPositiveClick: (dialog: DialogInterface, Int) -> Unit,
    onNegativeClick: (dialog: DialogInterface, Int) -> Unit
): AlertDialog {
    val builder = AlertDialog.Builder(this)
    builder.setTitle(aTitleText)
    builder.setMessage(aMsgText)
    builder.setPositiveButton(aPositiveText) { dialog, which ->
        onPositiveClick(dialog, which)
    }
    builder.setNegativeButton(aNegativeText) { dialog, which ->
        onNegativeClick(dialog, which)
    }
    return builder.create()
}



fun clearLoginPref() {

}

fun ImageView.loadImageFromUrl(
    aImageUrl: String,
    aPlaceHolderImage: Int = R.drawable.placeholder,
    aErrorImage: Int = R.drawable.placeholder
) {
    try {
        if (!aImageUrl.checkIsEmpty()) {
            Glide.with(getAppInstance()).load(aImageUrl).placeholder(aPlaceHolderImage)
                .error(aErrorImage).into(this)
        } else {
            loadImageFromDrawable(aPlaceHolderImage)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }


}

fun Activity.openLottieDialog(
    jsonFileCode: JsonFileCode = JsonFileCode.NO_INTERNET,
    onLottieClick: () -> Unit
) {
    try {
        val jsonFile: String = when (jsonFileCode) {
            JsonFileCode.NO_INTERNET -> "lottie/no_internet.json"
            JsonFileCode.LOADER -> "lottie/loader.json"
        }

        if (noInternetDialog == null) {
            noInternetDialog = Dialog(this, R.style.FullScreenDialog)
            noInternetDialog?.setContentView(R.layout.dialog_no_internet); noInternetDialog?.setCanceledOnTouchOutside(
                false
            ); noInternetDialog?.setCancelable(false)
            noInternetDialog?.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            noInternetDialog?.rlLottie?.onClick {
                if (!isNetworkAvailable()) {
                    snackBarError(getAppInstance().getString(R.string.error_no_internet))
                    return@onClick
                }
                noInternetDialog?.dismiss()
                onLottieClick()
            }
        }
        noInternetDialog?.lottieNoInternet?.setAnimation(jsonFile)
        if (!this.isFinishing && !noInternetDialog!!.isShowing) {
            noInternetDialog?.show()
        }
    } catch (e: Exception) {

    }

}


enum class JsonFileCode {
    NO_INTERNET,
    LOADER
}


fun RecyclerView.rvItemAnimation() {
    layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)
}

