package com.stupacki.hilt.app.feature.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.stupacki.hilt.app.App
import com.stupacki.hilt.app.MainActivity
import com.stupacki.hilt.app.feature.R
import com.stupacki.hilt.app.feature.databinding.FragmentFeatureBinding
import com.stupacki.hilt.app.feature.injection.DaggerFeatureComponent
import com.stupacki.hilt.app.feature.viewmodel.FeatureViewModel
import com.stupacki.hilt.app.injection.CommonDependencies
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch

internal class FeatureFragment : Fragment(R.layout.fragment_feature) {

    private var _binding: FragmentFeatureBinding? = null

    private val featureViewModel: FeatureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val featureComponent = (requireActivity().applicationContext as App)

        DaggerFeatureComponent.builder()
            .context(requireActivity())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireActivity().applicationContext,
                    CommonDependencies::class.java
                )
            )
            .build()
            .inject(requireActivity() as MainActivity)

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
