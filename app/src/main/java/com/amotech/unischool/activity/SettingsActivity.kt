package com.amotech.unischool.activity

import android.os.Bundle
import android.os.Handler
import com.amotech.unischool.AppBaseActivity
import com.amotech.unischool.GuidanceApp
import com.amotech.unischool.R
import com.amotech.unischool.util.Constants
import com.amotech.unischool.utils.extensions.switchToDarkMode
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.toolbar.*

class SettingsActivity : AppBaseActivity() {
    private lateinit var lan: String
    private var mIsSelectedByUser = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        title = getString(R.string.lbl_settings)
        setToolbar(toolbar)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        lan = GuidanceApp.language

        switchNightMode.isChecked = GuidanceApp.appTheme == Constants.THEME.DARK


        switchNightMode.setOnCheckedChangeListener { _, isChecked ->
            GuidanceApp.changeAppTheme(isChecked)
            switchToDarkMode(isChecked)
        }
        Handler().postDelayed({ mIsSelectedByUser = true }, 1000)

    }


}