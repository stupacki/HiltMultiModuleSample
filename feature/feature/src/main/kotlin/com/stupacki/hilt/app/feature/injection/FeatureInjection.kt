package com.stupacki.hilt.app.feature.injection

import android.content.Context
import com.stupacki.hilt.app.domain.calcualtion.injection.CalculationDependencies
import com.stupacki.hilt.app.feature.view.FeatureFragment
import dagger.BindsInstance
import dagger.Component

@Component()
internal interface FeatureComponent {

    fun inject(fragment: FeatureFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(calculationDependencies: CalculationDependencies): Builder
        fun build(): FeatureComponent
    }
}
