package com.example.asrekaf.home.import

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.asrekaf.R
import com.example.asrekaf.databinding.FragmentImportBinding
import com.example.asrekaf.home.model.ImportViewModel
import com.example.asrekaf.model.Core

class ImportFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var viewModel: ImportViewModel
    private lateinit var binding: FragmentImportBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_import, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ImportViewModel::class.java)

        binding.importViewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener?.changeToolbar(TITLE)

        binding.apiKeyButton.setOnClickListener {
            Core.setKey(viewModel.apiKey)
            listener?.backToHome()
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
        fun changeToolbar(fragmentName: String)
        fun backToHome()
    }

    companion object {
        const val TITLE = "Import Api Key"
    }
}