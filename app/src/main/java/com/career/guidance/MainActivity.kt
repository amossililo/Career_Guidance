package com.career.guidance

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.career.guidance.activity.*
import com.career.guidance.fragment.HomeFragment
import com.career.guidance.util.Constants
import com.career.guidance.utils.extensions.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_bar.*
import kotlinx.android.synthetic.main.layout_sidebar.*
import kotlinx.android.synthetic.main.menu_profile.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppBaseActivity() {
    private lateinit var mHomeFragment: Fragment
    private var selectedFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.findFragmentById(R.id.container) != null) {
            supportFragmentManager.beginTransaction()
                .remove(supportFragmentManager.findFragmentById(R.id.container)!!).commit()
        }
        mHomeFragment = HomeFragment()
        setToolbar(toolbar); setUpDrawerToggle(); loadHomeFragment(); setListener()
    }

    private fun setUpDrawerToggle() {
        val toggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                if (GuidanceApp.language == "ar") {
                    main.translationX = -slideOffset * drawerView.width
                } else {
                    main.translationX = slideOffset * drawerView.width
                }
                (drawer_layout).bringChildToFront(drawerView)
                (drawer_layout).requestLayout()
            }
        }
        toggle.setToolbarNavigationClickListener {
            if (drawer_layout.isDrawerVisible(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            } else {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }
        toggle.isDrawerIndicatorEnabled = false
        toggle.setHomeAsUpIndicator(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.ic_drawer,
                theme
            )
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun loadHomeFragment() {
        enable(ivHome)
        loadFragment(mHomeFragment)
        title = getString(R.string.home)
        if (mHomeFragment is HomeFragment) {
            (mHomeFragment as HomeFragment)
        }

    }

    private fun enable(aImageView: ImageView?) {
        disableAll()
        aImageView?.background =
            AppCompatResources.getDrawable(this, R.drawable.bg_circle_primary_light)
        aImageView?.applyColorFilter(color(R.color.colorPrimary))
    }

    //region Clicks
    private fun setListener() {
        tvSettings.onClick {
            launchActivity<SettingsActivity>(requestCode = Constants.RequestCode.SETTINGS)
            closeDrawer()
        }


        tvRateUs.onClick {
            rateUs5Star(this@MainActivity)
            closeDrawer()
        }
        tvShareApp.onClick {
            closeDrawer(); shareMyApp(
            this@MainActivity,
            "Career Guidance App",
            "Lorem ipsum"
        )
        }
        tvHelp.onClick { launchActivity<HelpActivity>(); closeDrawer() }

        tvFaq.onClick { launchActivity<FAQActivity>(); closeDrawer() }
        tvContactus.onClick { launchActivity<ContactUsActivity>(); closeDrawer() }
        tvAbout.onClick { launchActivity<AboutUsActivity>(); closeDrawer() }
        ivCloseDrawer.onClick { closeDrawer() }

    }

    private fun loadFragment(aFragment: Fragment) {
        if (selectedFragment != null) {
            if (selectedFragment == aFragment) return
            hideFragment(selectedFragment!!)
        }
        if (aFragment.isAdded) {
            showFragment(aFragment)
        } else {

            addFragment(aFragment, R.id.container)
        }
        selectedFragment = aFragment
    }

    private fun closeDrawer() {
        if (drawer_layout.isDrawerOpen(llLeftDrawer)) runDelayed(50) {
            drawer_layout.closeDrawer(
                llLeftDrawer
            )
        }
    }

    private fun disableAll() {
        disable(ivHome)

        disable(ivProfile)
    }

    private fun disable(aImageView: ImageView?) {
        aImageView?.background = null
        aImageView?.applyColorFilter(color(R.color.textColorSecondary))
    }

}