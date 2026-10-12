package com.lemanty.greatadventure.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.lemanty.greatadventure.R
import com.lemanty.greatadventure.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            view.updatePadding(left = bars.left, top = bars.top, right = bars.right, bottom = bars.bottom)
            insets
        }
        ViewCompat.requestApplyInsets(binding.root)
        binding.exploreButton.setOnClickListener { viewModel.select(Feature.EXPLORE) }
        binding.weatherButton.setOnClickListener { viewModel.select(Feature.WEATHER) }
        binding.journalButton.setOnClickListener { viewModel.select(Feature.JOURNAL) }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.selectedFeature.collect { feature ->
                    binding.featureStatus.setText(when (feature) {
                        Feature.EXPLORE -> R.string.explore_status
                        Feature.WEATHER -> R.string.weather_status
                        Feature.JOURNAL -> R.string.journal_status
                    })
                }
            }
        }
    }
}
