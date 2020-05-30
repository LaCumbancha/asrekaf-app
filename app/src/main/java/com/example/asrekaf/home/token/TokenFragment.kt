package com.example.asrekaf.home.token

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.asrekaf.R
import com.example.asrekaf.databinding.FragmentTokenBinding

import com.example.asrekaf.home.model.TokenViewModel

class TokenFragment(private val token: String) : Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var viewModel: TokenViewModel
    private lateinit var binding: FragmentTokenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_token, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(TokenViewModel::class.java)

        viewModel.token = token
        binding.tokenViewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener?.changeToolbar(TITLE)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun changeToolbar(fragmentName: String)
    }

    companion object {
        const val TITLE = "Token"
    }
}