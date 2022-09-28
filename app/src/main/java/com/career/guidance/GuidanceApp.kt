package com.career.guidance

import android.app.Dialog
import android.content.Context

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.career.guidance.util.Constants
import com.career.guidance.util.Constants.SharedPref.LANGUAGE
import com.career.guidance.utils.LocaleManager
import com.career.guidance.utils.SharedPrefUtils
import com.career.guidance.utils.extensions.getSharedPrefInstance

import com.squareup.okhttp.OkHttpClient
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class GuidanceApp :MultiDexApplication(){
    override fun onCreate() {
        super.onCreate()
        appInstance = this
        getSharedPrefInstance().apply {
            appTheme = getIntValue(Constants.SharedPref.THEME, Constants.THEME.LIGHT)
            language = getStringValue(LANGUAGE, "en")
        }

        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath(getString(R.string.font_regular))
                            .setFontAttrId(io.github.inflationx.calligraphy3.R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )


    }


    override fun attachBaseContext(base: Context) {
        localeManager = LocaleManager(base)
        appInstance = this
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        lateinit var localeManager: LocaleManager
        private lateinit var appInstance: GuidanceApp

        //  var restApis: RestApis? = null
        var okHttpClient: OkHttpClient? = null
        var sharedPrefUtils: SharedPrefUtils? = null
        var noInternetDialog: Dialog? = null
        lateinit var language: String
        var appTheme: Int = 0

        fun getAppInstance(): GuidanceApp {
            return appInstance
        }

        fun changeAppTheme(isDark: Boolean) {
            getSharedPrefInstance().apply {
                when {
                    isDark -> setValue(Constants.SharedPref.THEME, Constants.THEME.DARK)
                    else -> setValue(Constants.SharedPref.THEME, Constants.THEME.LIGHT)
                }
                appTheme = getIntValue(Constants.SharedPref.THEME, Constants.THEME.LIGHT)
            }

        }

    }



}

