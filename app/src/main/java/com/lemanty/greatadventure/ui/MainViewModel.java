package com.lemanty.greatadventure.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private static final String SELECTED_FEATURE = "selectedFeature";
    private final SavedStateHandle savedStateHandle;
    private final LiveData<Feature> selectedFeature;

    public MainViewModel(SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;
        selectedFeature = savedStateHandle.getLiveData(SELECTED_FEATURE, Feature.EXPLORE);
    }

    public LiveData<Feature> getSelectedFeature() {
        return selectedFeature;
    }

    public void select(Feature feature) {
        savedStateHandle.set(SELECTED_FEATURE, feature);
    }
}
