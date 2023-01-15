package com.stupacki.hilt.app.feature.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.stupacki.hilt.app.App
import com.stupacki.hilt.app.domain.calcualtion.injection.CalculationDependencies
import com.stupacki.hilt.app.feature.R
import com.stupacki.hilt.app.feature.databinding.FragmentFeatureBinding
import com.stupacki.hilt.app.feature.injection.DaggerFeatureComponent
import com.stupacki.hilt.app.feature.viewmodel.FeatureViewModel
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch


internal class FeatureFragment : Fragment(R.layout.fragment_feature) {

    private var _binding: FragmentFeatureBinding? = null

    private val featureViewModel: FeatureViewModel by viewModels()

    override fun onAttach(context: Context) {
        DaggerFeatureComponent.builder()
            .context(requireContext())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireContext().applicationContext,
                    CalculationDependencies::class.java
                )
            )
            .build()
            .inject(this)

        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val featureComponent = (requireActivity().applicationContext as App)

        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFeatureBinding.bind(view).apply {

            incButton.setOnClickListener { featureViewModel.onIncClicked() }

            decButton.setOnClickListener { featureViewModel.dec() }

            viewLifecycleOwner.lifecycleScope.launch {
                featureViewModel.featureState.collect { count ->
                    counterView.text = count.toString()
                }
            }
        }
    }

    override fun onDestroy() {
        cleanMemory()
        super.onDestroy()
    }

    private fun cleanMemory() {
        _binding = null
    }
}
