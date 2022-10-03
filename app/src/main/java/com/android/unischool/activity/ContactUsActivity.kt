package com.android.unischool.activity

import android.os.Bundle
import android.view.Menu
import com.android.unischool.AppBaseActivity
import com.android.unischool.R
import com.android.unischool.utils.extensions.dialNumber
import com.android.unischool.utils.extensions.launchActivity
import com.android.unischool.utils.extensions.onClick
import kotlinx.android.synthetic.main.activity_contact_us.*
import kotlinx.android.synthetic.main.toolbar.*

class ContactUsActivity : AppBaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)
        title = getString(R.string.title_contactus)
        setToolbar(toolbar)

        llCallRequest.onClick {
            dialNumber(getString(R.string.contact_phone))
        }
        llEmail.onClick {
            launchActivity<EmailActivity>()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return super.onCreateOptionsMenu(menu)
    }

}