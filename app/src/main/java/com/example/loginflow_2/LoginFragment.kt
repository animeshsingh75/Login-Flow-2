package com.example.loginflow_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.loginflow_2.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val animSlideFromBottom = AnimationUtils.loadAnimation(
            requireActivity(),
            R.anim.slide_in_from_bottom
        )
        val fadeIn = AnimationUtils.loadAnimation(
            requireActivity(),
            R.anim.fade_in
        )
        val animSlideFromTop = AnimationUtils.loadAnimation(
            requireActivity(),
            R.anim.slide_in_from_top
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
                val phoneFragment = PhoneFragment()
                val fragmentManager = parentFragmentManager
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container_view,phoneFragment)
                fragmentTransaction.commit()
            }
        }
        return binding.root
    }
}