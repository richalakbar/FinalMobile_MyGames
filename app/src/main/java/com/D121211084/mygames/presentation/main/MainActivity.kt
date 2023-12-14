package com.D121211084.mygames.presentation.main

import android.os.Bundle
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import com.D121211084.mygames.binding.viewBinding
import com.D121211084.mygames.R
import com.D121211084.mygames.databinding.ActivityMainBinding
import com.D121211084.mygames.utils.gone
import com.D121211084.mygames.utils.visible

@AndroidEntryPoint
class  MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    private fun initUI() {
        with(binding) {
            val nav = supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
            nav.navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.homeFragment,
                    R.id.searchFragment -> {
//                    R.id.favouritesFragment -> {
                        showBottomNav()
                    }
                    else -> hideBottomNav()
                }
            }
            bnMain.setupWithNavController(nav.navController)
            bnMain.setOnItemSelectedListener {
                NavigationUI.onNavDestinationSelected(it, nav.navController)
                nav.navController.popBackStack(it.itemId, false)
            }
        }
    }

    private fun showBottomNav(duration: Int = 400) {
        with(binding) {
            if (bnMain.isVisible) return
            bnMain.visible()
            divider.visible()
            val animate = TranslateAnimation(0f, 0f, bnMain.height.toFloat(), 0f)
            animate.duration = duration.toLong()
            bnMain.startAnimation(animate)
            divider.startAnimation(animate)
        }
    }

    private fun hideBottomNav(duration: Int = 400) {
        with(binding) {
            if (bnMain.isGone) return
            val animate = TranslateAnimation(0f, 0f, 0f, bnMain.height.toFloat())
            animate.duration = duration.toLong()
            bnMain.startAnimation(animate)
            divider.startAnimation(animate)
            bnMain.gone()
            divider.gone()
        }
    }

}