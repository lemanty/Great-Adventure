package com.lemanty.greatadventure.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import com.lemanty.greatadventure.R;
import com.lemanty.greatadventure.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (view, insets) -> {
            Insets bars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });
        ViewCompat.requestApplyInsets(binding.getRoot());

        binding.exploreButton.setOnClickListener(v -> viewModel.select(Feature.EXPLORE));
        binding.weatherButton.setOnClickListener(v -> viewModel.select(Feature.WEATHER));
        binding.journalButton.setOnClickListener(v -> viewModel.select(Feature.JOURNAL));
        viewModel.getSelectedFeature().observe(this, feature -> {
            if (feature == null) return;
            switch (feature) {
                case EXPLORE:
                    binding.featureStatus.setText(R.string.explore_status);
                    break;
                case WEATHER:
                    binding.featureStatus.setText(R.string.weather_status);
                    break;
                case JOURNAL:
                    binding.featureStatus.setText(R.string.journal_status);
                    break;
            }
        });
    }
}
