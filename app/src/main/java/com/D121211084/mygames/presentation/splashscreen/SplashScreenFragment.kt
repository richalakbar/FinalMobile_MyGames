package com.D121211084.mygames.presentation.splashscreen

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.D121211084.mygames.base.BaseFragment
import com.D121211084.mygames.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class SplashScreenFragment : BaseFragment(R.layout.fragment_splash_screen) {

    override fun initObserver() {
        super.initObserver()
        lifecycleScope.launch {
            delay(3.seconds)
            navigateToHomeDashboard()
        }
    }

    private fun navigateToHomeDashboard() {
        findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToHomeFragment())
    }

}