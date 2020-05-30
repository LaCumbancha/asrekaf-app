package com.example.asrekaf.home

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.asrekaf.R
import com.example.asrekaf.databinding.FragmentHomeBinding
import com.example.asrekaf.home.import.ImportFragment
import com.example.asrekaf.home.model.HomeViewModel
import com.example.asrekaf.model.Core
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        binding.homeViewModel = viewModel
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener?.changeToolbar(TITLE)

        binding.apiKeyInput.setOnClickListener {
            val token = Core.generateToken(viewModel.code)
            listener?.showToken(token)
        }

        importButton.setOnClickListener {
            listener?.showFragment(ImportFragment())
        }
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
        fun showFragment(fragment: Fragment)
        fun changeToolbar(fragmentName: String)
        fun showToken(token: String)
    }

    companion object {
        const val TITLE = "Asrekaf"
    }
}