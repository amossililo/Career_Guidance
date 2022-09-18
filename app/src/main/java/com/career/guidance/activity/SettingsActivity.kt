package com.career.guidance.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.career.guidance.AppBaseActivity
import com.career.guidance.GuidanceApp
import com.career.guidance.GuidanceApp.Companion.language
import com.career.guidance.MainActivity
import com.career.guidance.R
import com.career.guidance.util.Constants
import com.career.guidance.utils.extensions.launchActivityWithNewTask
import com.career.guidance.utils.extensions.switchToDarkMode
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlin.system.exitProcess

class SettingsActivity : AppBaseActivity() {
    private lateinit var lan: String
    private var mIsSelectedByUser = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        title = getString(R.string.title_setting)
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