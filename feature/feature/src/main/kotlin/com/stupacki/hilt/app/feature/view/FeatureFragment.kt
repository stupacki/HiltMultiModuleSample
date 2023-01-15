package com.stupacki.hilt.app.feature.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.stupacki.hilt.app.App
import com.stupacki.hilt.app.domain.calcualtion.usecase.DecUseCase
import com.stupacki.hilt.app.domain.calcualtion.usecase.IncUseCase
import com.stupacki.hilt.app.feature.R
import com.stupacki.hilt.app.feature.databinding.FragmentFeatureBinding
import com.stupacki.hilt.app.feature.viewmodel.FeatureViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class FeatureFragment : Fragment(R.layout.fragment_feature) {

    private var _binding: FragmentFeatureBinding? = null

    private val inc: IncUseCase by lazy { IncUseCase(Dispatchers.IO) }
    private val dec: DecUseCase by lazy { DecUseCase(Dispatchers.IO) }
    private val featureViewModel: FeatureViewModel by lazy {
        FeatureViewModel(inc, dec)
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
