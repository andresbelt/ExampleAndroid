package com.valid.ui.component.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.task.ui.base.BaseActivity
import com.valid.databinding.ActivityMenuBinding

class MenuActivity : BaseActivity() {

    private lateinit var binding: ActivityMenuBinding
    override fun initializeViewModel() {
    }

    override fun observeViewModel() {
    }

    override fun initViewBinding() {
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.button.setOnClickListener(View.OnClickListener {
            val nextScreenIntent = Intent(this, TracksActivity::class.java)
            startActivity(nextScreenIntent)

        })

        binding.button2.setOnClickListener(View.OnClickListener {
            val nextScreenIntent = Intent(this, ArtistsActivity::class.java)
            startActivity(nextScreenIntent)

        })
    }
}