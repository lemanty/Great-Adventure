package com.lemanty.greatadventure.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

enum class Feature { EXPLORE, WEATHER, JOURNAL }

class MainViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val selectedFeature: StateFlow<Feature> =
        savedStateHandle.getStateFlow("selectedFeature", Feature.EXPLORE)

    fun select(feature: Feature) {
        savedStateHandle["selectedFeature"] = feature
    }
}
