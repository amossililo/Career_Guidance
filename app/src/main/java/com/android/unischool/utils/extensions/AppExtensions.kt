package com.android.unischool.utils.extensions

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.android.unischool.GuidanceApp
import com.android.unischool.GuidanceApp.Companion.getAppInstance
import com.android.unischool.R
import com.android.unischool.util.Constants.PLAY_STORE_URL_PREFIX
import com.android.unischool.utils.SharedPrefUtils
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



fun RecyclerView.rvItemAnimation() {
    layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)
}

