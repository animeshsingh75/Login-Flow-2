package com.example.loginflow_2

import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.example.loginflow_2.databinding.FragmentPhoneBinding

class PhoneFragment : Fragment() {
    lateinit var binding: FragmentPhoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhoneBinding.inflate(inflater, container, false)
        val slideVariant = AnimationUtils.loadAnimation(
            requireActivity(),
            R.anim.slide_variant
        )
        val animSlideFromBottom = AnimationUtils.loadAnimation(
            requireActivity(),
            R.anim.slide_in_from_bottom
        )
        binding.apply {
            this.fadedImageView.startAnimation(slideVariant)
            this.otpButton.startAnimation(animSlideFromBottom)
            this.phoneEditText.requestFocus()
            val imm: InputMethodManager =
                requireActivity().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(
                binding.phoneEditText,
                InputMethodManager.HIDE_IMPLICIT_ONLY
            )
            this.otpButton.setOnClickListener {
                val intent = Intent(requireActivity(),OtpActivity::class.java)
                intent.putExtra("phone_number", binding.phoneEditText.text.toString())
                startActivity(intent)
            }
        }

        return binding.root
    }
}