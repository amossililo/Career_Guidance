package com.android.unischool.activity

import android.os.Bundle
import com.android.unischool.AppBaseActivity
import com.android.unischool.R
import com.android.unischool.util.Constants.SharedPref.CONTACT
import com.android.unischool.util.Constants.SharedPref.COPYRIGHT_TEXT
import com.android.unischool.util.Constants.SharedPref.FACEBOOK
import com.android.unischool.util.Constants.SharedPref.INSTAGRAM
import com.android.unischool.util.Constants.SharedPref.PRIVACY_POLICY
import com.android.unischool.util.Constants.SharedPref.TERM_CONDITION
import com.android.unischool.util.Constants.SharedPref.TWITTER
import com.android.unischool.util.Constants.SharedPref.WHATSAPP
import com.android.unischool.utils.extensions.*
import kotlinx.android.synthetic.main.activity_about_us.*
import kotlinx.android.synthetic.main.toolbar.*

class AboutUsActivity : AppBaseActivity() {
    private var whatsUp: String = ""
    private var instagram: String = ""
    private var twitter: String = ""
    private var facebook: String = ""
    private var contact: String = ""
    private var copyRight: String = ""
    private var privacy: String = ""
    private var toc: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        setToolbar(toolbar)
        title = getString(R.string.lbl_about)

        getSharedPrefInstance().apply {
            whatsUp = getStringValue(WHATSAPP)
            instagram = getStringValue(INSTAGRAM)
            twitter = getStringValue(TWITTER)
            facebook = getStringValue(FACEBOOK)

            contact = getStringValue(CONTACT)
            copyRight = getStringValue(COPYRIGHT_TEXT)
            privacy = getStringValue(PRIVACY_POLICY)
            toc = getStringValue(TERM_CONDITION)
        }
        if (copyRight.isEmpty()) {
            tvCopyRight.hide()
        } else {
            tvCopyRight.text = copyRight
            tvCopyRight.show()
        }

        if (whatsUp.isEmpty()) iv_whatsapp.hide()
        if (privacy.isEmpty()) tvPrivacyPolicy.hide()
        if (toc.isEmpty()) tvTOC.hide()
        if (instagram.isEmpty()) iv_instagram.hide()
        if (twitter.isEmpty()) iv_twitter_sign.hide()
        if (facebook.isEmpty()) iv_facebook.hide()
        if (contact.isEmpty()) iv_contact.hide()
        llBottom.show()

        iv_whatsapp.onClick { openCustomTab("https://wa.me/${whatsUp}") }
        iv_instagram.onClick { openCustomTab(instagram) }
        iv_twitter_sign.onClick { openCustomTab(twitter) }
        iv_facebook.onClick { openCustomTab(facebook) }
        iv_contact.onClick { dialNumber(contact) }
        tvPrivacyPolicy.onClick { openCustomTab(privacy) }
        tvTOC.onClick { openCustomTab(toc) }
    }
}