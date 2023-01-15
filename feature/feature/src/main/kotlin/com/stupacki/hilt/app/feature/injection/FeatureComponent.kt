package com.stupacki.hilt.app.feature.injection

import android.content.Context
import com.stupacki.hilt.app.MainActivity
import com.stupacki.hilt.app.injection.CommonDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [CommonDependencies::class])
internal interface FeatureComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(featureModuleDependencies: CommonDependencies): Builder
        fun build(): FeatureComponent
    }
}
