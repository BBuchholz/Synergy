package com.nineworldsdeep.synergy.ui.synergy

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nineworldsdeep.synergy.R

class SynergyFragment : Fragment() {

    companion object {
        fun newInstance() = SynergyFragment()
    }

    private lateinit var viewModel: SynergyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.synergy_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SynergyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
