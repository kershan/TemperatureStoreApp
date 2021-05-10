package online.platformer.temperaturestoreapp

import android.app.Application
import online.platformer.temperaturestoreapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class TemperatureStoreApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@TemperatureStoreApp)
            modules(appModule)
        }
    }
}