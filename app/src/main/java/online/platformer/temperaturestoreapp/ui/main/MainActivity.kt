package online.platformer.temperaturestoreapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import online.platformer.temperaturestoreapp.R
import online.platformer.temperaturestoreapp.domain.main.MainViewModel
import online.platformer.temperaturestoreapp.ui.dashboard.DashboardFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DashboardFragment.newInstance())
                .commitNow()
        }

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}