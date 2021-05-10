package online.platformer.temperaturestoreapp.domain.dashboard

import androidx.lifecycle.ViewModel
import online.platformer.temperaturestoreapp.repository.TemperatureRepository


class DashboardViewModel(temperatureRepository: TemperatureRepository) : ViewModel() {
    val latestTemperature = temperatureRepository.latestTemperature
    val latestHumidity = temperatureRepository.latestHumidity
    val topTemperature = temperatureRepository.topTemperature
    val topHumidity = temperatureRepository.topHumidity
}