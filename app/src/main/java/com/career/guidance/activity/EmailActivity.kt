package com.career.guidance.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.career.guidance.AppBaseActivity
import com.career.guidance.R
import com.career.guidance.utils.extensions.checkIsEmpty
import com.career.guidance.utils.extensions.onClick
import com.career.guidance.utils.extensions.showError
import kotlinx.android.synthetic.main.activity_email.*
import kotlinx.android.synthetic.main.toolbar.*

class EmailActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
        title = getString(R.string.lbl_email)
        setToolbar(toolbar)

        val input= getString(R.string.lbl_email)
        var string = ""

        for (char in input.indices){

            string = input[char].toString()
        }
        string.indices
        btnSendMail.onClick {
            when {
                validate() -> {
                    val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", getString(R.string.text_iqonicdesign_gmail_com), null))
                    emailIntent.putExtra(Intent.EXTRA_TEXT, edtDescription.text.toString())
                    startActivity(Intent.createChooser(emailIntent, context.getString(R.string.lbl_send_email)))
                }
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return super.onCreateOptionsMenu(menu)
    }


    private fun validate(): Boolean {
        return when {

            edtDescription.checkIsEmpty() -> {
                edtDescription.showError(getString(R.string.error_field_required))
                false
            }
            else -> true
        }
    }
}