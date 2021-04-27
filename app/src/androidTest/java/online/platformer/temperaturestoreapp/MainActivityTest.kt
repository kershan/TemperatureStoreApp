package online.platformer.temperaturestoreapp

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Test

class MainActivityTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("online.platformer.temperaturestoreapp", appContext.packageName)
    }

}