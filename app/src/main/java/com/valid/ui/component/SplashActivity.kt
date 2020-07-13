package com.valid.ui.component

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.valid.databinding.ActivitySplashBinding
import com.valid.util.Constants
import com.task.ui.base.BaseActivity
import com.valid.ui.component.main.MenuActivity


class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun initViewBinding() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToMainScreen()
    }

    override fun initializeViewModel() {
        null
    }

    override fun observeViewModel() {

    }

    private fun navigateToMainScreen() {
        Handler().postDelayed({
            val nextScreenIntent = Intent(this, MenuActivity::class.java)
            startActivity(nextScreenIntent)
            finish()
        }, Constants.SPLASH_DELAY.toLong())
    }
}