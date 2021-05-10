package online.platformer.temperaturestoreapp.repository

import androidx.lifecycle.LiveData

interface TemperatureRepository {
    val latestTemperature: LiveData<Double>
    val latestHumidity: LiveData<Int>
    val topTemperature: LiveData<Double>
    val topHumidity: LiveData<Int>
}