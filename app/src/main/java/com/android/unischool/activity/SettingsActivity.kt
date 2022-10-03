package com.android.unischool.activity

import android.os.Bundle
import android.os.Handler
import com.android.unischool.AppBaseActivity
import com.android.unischool.GuidanceApp
import com.android.unischool.R
import com.android.unischool.util.Constants
import com.android.unischool.utils.extensions.switchToDarkMode
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