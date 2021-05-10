package online.platformer.temperaturestoreapp.di

import online.platformer.temperaturestoreapp.domain.dashboard.DashboardViewModel
import online.platformer.temperaturestoreapp.domain.main.MainViewModel
import online.platformer.temperaturestoreapp.repository.TemperatureRepository
import online.platformer.temperaturestoreapp.repository.TemperatureRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<TemperatureRepository> { TemperatureRepositoryImpl() }

    viewModel { DashboardViewModel(get()) }
    viewModel { MainViewModel() }
}