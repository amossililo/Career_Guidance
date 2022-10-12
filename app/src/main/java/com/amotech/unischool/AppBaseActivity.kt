package com.amotech.unischool

import android.app.Dialog
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.amotech.unischool.GuidanceApp.Companion.noInternetDialog
import com.amotech.unischool.util.Constants.SharedPref.CONTACT
import com.amotech.unischool.util.Constants.SharedPref.COPYRIGHT_TEXT
import com.amotech.unischool.util.Constants.SharedPref.FACEBOOK
import com.amotech.unischool.util.Constants.SharedPref.INSTAGRAM
import com.amotech.unischool.util.Constants.SharedPref.LANGUAGE
import com.amotech.unischool.util.Constants.SharedPref.PRIVACY_POLICY
import com.amotech.unischool.util.Constants.SharedPref.TERM_CONDITION
import com.amotech.unischool.util.Constants.SharedPref.TWITTER
import com.amotech.unischool.util.Constants.SharedPref.WHATSAPP
import com.amotech.unischool.util.Constants.THEME.DARK
import com.amotech.unischool.utils.extensions.changeToolbarFont
import com.amotech.unischool.utils.extensions.getSharedPrefInstance
import com.amotech.unischool.utils.extensions.launchActivityWithNewTask
import com.amotech.unischool.utils.extensions.switchToDarkMode
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import java.util.*

open class AppBaseActivity : AppCompatActivity() {
//todo: if you add adds, be sure to update that on the play console ie here https://play.google.com/console/u/0/developers/6829671500077182359/app/4975508974003541699/app-content/ad-id-declaration


    private var progressDialog: Dialog? = null

    var language: Locale? = null
    private var themeApp: Int = 0


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
        getSharedPrefInstance().setValue(WHATSAPP, "+260975341298")
        getSharedPrefInstance().setValue(CONTACT, "0975341298")
        getSharedPrefInstance().setValue(PRIVACY_POLICY, "")
        getSharedPrefInstance().setValue(INSTAGRAM, "instagram.com")
        getSharedPrefInstance().setValue(
            COPYRIGHT_TEXT,
            "Developed by Amos Banda and Ren Technology"
        )
        getSharedPrefInstance().setValue(TWITTER, "twitter.com")
        getSharedPrefInstance().setValue(FACEBOOK, "facebook.com/rogic.Kachanta")
        getSharedPrefInstance().setValue(TERM_CONDITION, "")

        //deleteNewest()


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
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