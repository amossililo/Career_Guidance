package com.android.unischool.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import com.android.unischool.AppBaseActivity
import com.android.unischool.R
import com.android.unischool.utils.extensions.checkIsEmpty
import com.android.unischool.utils.extensions.isValidEmail
import com.android.unischool.utils.extensions.onClick
import com.android.unischool.utils.extensions.showError
import kotlinx.android.synthetic.main.activity_help.*
import kotlinx.android.synthetic.main.toolbar.*

class HelpActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        title = getString(R.string.title_help)
        setToolbar(toolbar)

        btnSubmit.onClick {
            when {
                validate() -> {
                    val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", getString(R.string.text_iqonicdesign_gmail_com), null))
                    emailIntent.putExtra(Intent.EXTRA_TEXT, edtDescription.text.toString())
                    startActivity(Intent.createChooser(emailIntent, "Send email..."))
                    finish()
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return super.onCreateOptionsMenu(menu)
    }


    private fun validate(): Boolean {
        return when {
            edtContact.checkIsEmpty() -> {
                edtContact.showError(getString(R.string.error_field_required))
                false
            }
            /** !edtContact.isValidPhoneNumber() -> {
            edtContact.showError(getString(R.string.error_enter_valid_contact))
            false
            }**/
            edtEmail.checkIsEmpty() -> {
                edtEmail.showError(getString(R.string.error_field_required))
                false
            }
            !edtEmail.isValidEmail() -> {
                edtEmail.showError(getString(R.string.error_enter_valid_email))
                false
            }
            edtDescription.checkIsEmpty() -> {
                edtDescription.showError(getString(R.string.error_field_required))
                false
            }
            else -> true
        }
    }

}