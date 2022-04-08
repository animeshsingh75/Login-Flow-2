package com.example.loginflow_2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils.loadAnimation
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.loginflow_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val animSlideFromBottom = loadAnimation(
            applicationContext,
            R.anim.slide_in_from_bottom
        )
        val fadeIn = loadAnimation(
            applicationContext,
            R.anim.fade_in
        )
        val animSlideFromTop = loadAnimation(
            applicationContext,
            R.anim.slide_in_from_top
        )
        val slideVariant = loadAnimation(
            applicationContext,
            R.anim.slide_variant
        )
        binding.apply {
            this.carImage.startAnimation(animSlideFromBottom)
            this.dummyText.startAnimation(animSlideFromTop)
            this.infoText.startAnimation(animSlideFromTop)
            this.loginButton.startAnimation(fadeIn)
            this.underlineImage.startAnimation(fadeIn)
            this.guestLogin.startAnimation(fadeIn)
            this.loginButton.visibility = View.VISIBLE
            this.guestLogin.visibility = View.VISIBLE
            this.underlineImage.visibility = View.VISIBLE
            this.loginButton.setOnClickListener {
                this.dummyText.visibility = View.GONE
                this.infoText.visibility = View.GONE
                this.carImage.visibility = View.GONE
                this.loginButton.visibility = View.GONE
                this.underlineImage.visibility = View.GONE
                this.guestLogin.visibility = View.GONE
                this.fadedImageView.visibility = View.VISIBLE
                this.backArrow.visibility = View.VISIBLE
                this.pleaseSignIn.visibility = View.VISIBLE
                this.phoneNumberLayout.visibility = View.VISIBLE
                this.otpButton.visibility = View.VISIBLE
                this.leftDivider.visibility = View.VISIBLE
                this.rightDivider.visibility = View.VISIBLE
                this.textOr.visibility = View.VISIBLE
                this.trueCallerBtn.visibility = View.VISIBLE
                this.fadedImageView.startAnimation(slideVariant)
                this.otpButton.startAnimation(animSlideFromBottom)
                this.phoneEditText.requestFocus()
                val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(
                    binding.phoneEditText,
                    InputMethodManager.HIDE_IMPLICIT_ONLY
                )
            }
            this.otpButton.setOnClickListener {
                val intent = Intent(this@MainActivity, OtpActivity::class.java)
                intent.putExtra("phone_number", binding.phoneEditText.text.toString())
                startActivity(intent)
            }
        }
    }
}