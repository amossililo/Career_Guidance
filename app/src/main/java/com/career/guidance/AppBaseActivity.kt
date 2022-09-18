package com.career.guidance

import android.app.Dialog
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.career.guidance.GuidanceApp.Companion.noInternetDialog
import com.career.guidance.util.Constants
import com.career.guidance.util.Constants.SharedPref.CONTACT
import com.career.guidance.util.Constants.SharedPref.COPYRIGHT_TEXT
import com.career.guidance.util.Constants.SharedPref.FACEBOOK
import com.career.guidance.util.Constants.SharedPref.INSTAGRAM
import com.career.guidance.util.Constants.SharedPref.LANGUAGE
import com.career.guidance.util.Constants.SharedPref.PRIVACY_POLICY
import com.career.guidance.util.Constants.SharedPref.TERM_CONDITION
import com.career.guidance.util.Constants.SharedPref.TWITTER
import com.career.guidance.util.Constants.SharedPref.WHATSAPP
import com.career.guidance.util.Constants.THEME.DARK
import com.career.guidance.utils.extensions.changeToolbarFont
import com.career.guidance.utils.extensions.getSharedPrefInstance
import com.career.guidance.utils.extensions.launchActivityWithNewTask
import com.career.guidance.utils.extensions.switchToDarkMode
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import java.util.*
import kotlin.collections.ArrayList

open class AppBaseActivity : AppCompatActivity() {

    private val TAG = "AppBaseActivity"

    private var progressDialog: Dialog? = null

    var language: Locale? = null
    private var themeApp: Int = 0
    var isAdShown = false

    fun setToolbarWithoutBackButton(mToolbar: Toolbar) {
        setSupportActionBar(mToolbar)
    }

    fun setToolbar(mToolbar: Toolbar) {
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace)
        mToolbar.changeToolbarFont()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        switchToDarkMode(GuidanceApp.appTheme == DARK)
        super.onCreate(savedInstanceState)
        noInternetDialog = null
        if (progressDialog == null) {
            progressDialog = Dialog(this)
            progressDialog?.window?.setBackgroundDrawable(ColorDrawable(0))
            progressDialog?.setContentView(R.layout.custom_dialog)
        }
        themeApp = GuidanceApp.appTheme
        language = Locale(GuidanceApp.language)
        // Inflate the layout for this fragment
        getSharedPrefInstance().setValue(WHATSAPP, "+260971537692")
        getSharedPrefInstance().setValue(CONTACT, "+260971537692")
        getSharedPrefInstance().setValue(PRIVACY_POLICY, "https://traders-way.flycricket.io/privacy.html")
        getSharedPrefInstance().setValue(INSTAGRAM, "http://instagram.com/ren_technology")
        getSharedPrefInstance().setValue(
            COPYRIGHT_TEXT,
            "© Ren Technology 2021 | All rights reserved"
        )
        getSharedPrefInstance().setValue(TWITTER, "http://twitter.com/BrandonRen7")
        getSharedPrefInstance().setValue(FACEBOOK, "http://facebook.com/brandon.ren.3760")
        getSharedPrefInstance().setValue(TERM_CONDITION, "")

        //deleteNewest()


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    fun showProgress(show: Boolean) {
        when {
            show -> {
                if (!isFinishing && !progressDialog!!.isShowing) {
                    progressDialog?.setCanceledOnTouchOutside(false)
                    progressDialog?.show()
                }
            }
            else -> try {
                if (progressDialog?.isShowing!! && !isFinishing) {
                    progressDialog?.dismiss()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun changeLanguage(context: Context, locale: Locale): Context {
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        config.setLayoutDirection(locale)
        return context.createConfigurationContext(config)
    }

    override fun attachBaseContext(newBase: Context?) {


        super.attachBaseContext(ViewPumpContextWrapper.wrap(updateBaseContextLocale(newBase!!)))
    }

    private fun updateBaseContextLocale(context: Context): Context {

        val language = getSharedPrefInstance().getStringValue(LANGUAGE, "en")
        val locale = Locale(language)
        Locale.setDefault(locale)
        return changeLanguage(context, locale)
    }

    override fun onStart() {
        Log.d("onStart", "called")
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        val locale = Locale(GuidanceApp.language)
        val appTheme = GuidanceApp.appTheme
        if (language != null && locale != language) {
            recreate()
            return
        }
        if (themeApp != 0 && themeApp != appTheme) {
            launchActivityWithNewTask<MainActivity>()
        }

    }



}