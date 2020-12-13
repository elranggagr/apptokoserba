package com.example.apptokoserba.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.apptokoserba.R
import com.example.apptokoserba.databinding.ActivityMainBinding
import com.example.apptokoserba.ui.auth.ApptokoserbaAuth
import com.example.apptokoserba.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener{
            ApptokoserbaAuth.logout (this) {
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
        }

        }
    }
}