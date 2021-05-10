package online.platformer.temperaturestoreapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import online.platformer.temperaturestoreapp.R
import online.platformer.temperaturestoreapp.domain.main.MainViewModel
import online.platformer.temperaturestoreapp.ui.dashboard.DashboardFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DashboardFragment.newInstance())
                .commitNow()
        }
    }
}