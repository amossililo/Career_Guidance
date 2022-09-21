package com.career.guidance.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.career.guidance.AppBaseActivity
import com.career.guidance.R
import com.career.guidance.utils.extensions.dialNumber
import com.career.guidance.utils.extensions.launchActivity
import com.career.guidance.utils.extensions.onClick
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