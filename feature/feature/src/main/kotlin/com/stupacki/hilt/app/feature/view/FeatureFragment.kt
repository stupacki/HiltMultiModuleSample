package com.stupacki.hilt.app.feature.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.stupacki.hilt.app.feature.R
import com.stupacki.hilt.app.feature.databinding.FragmentFeatureBinding
import com.stupacki.hilt.app.feature.view_model.FeatureViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
internal class FeatureFragment : Fragment(R.layout.fragment_feature) {

    private var _binding: FragmentFeatureBinding? = null

    private val featureViewModel by viewModels<FeatureViewModel>()

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
