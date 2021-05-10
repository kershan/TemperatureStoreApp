package online.platformer.temperaturestoreapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import online.platformer.temperaturestoreapp.model.TemperatureModel

class TemperatureRepositoryImpl : TemperatureRepository {
    private val database = FirebaseDatabase.getInstance()

    private val latestTemperatureReference = database.getReference("temperatures")
        .orderByChild("dateAdded")
        .limitToLast(1)

    private val highestTemperatureReference = database.getReference("temperatures")
        .orderByChild("temperature")
        .limitToLast(1)

    private var _latestTemperature = MutableLiveData<Double>()
    private var _latestHumidity = MutableLiveData<Int>()
    private var _topTemperature = MutableLiveData<Double>()
    private var _topHumidity = MutableLiveData<Int>()

    override val latestTemperature: LiveData<Double>
        get() = _latestTemperature

    override val latestHumidity: LiveData<Int>
        get() = _latestHumidity

    override val topTemperature: LiveData<Double>
        get() = _topTemperature

    override val topHumidity: LiveData<Int>
        get() = _topHumidity

    init {
        latestTemperatureReference.addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.children.first().getValue(TemperatureModel::class.java)
                value?.temperature?.let { _latestTemperature.postValue(it) }
                value?.humidity?.let { _latestHumidity.postValue(it) }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })


        highestTemperatureReference.addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.children.first().getValue(TemperatureModel::class.java)
                value?.temperature?.let { _topTemperature.postValue(it) }
                value?.humidity?.let { _topHumidity.postValue(it) }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }

    companion object {
        const val TAG = "TemperatureRepositoryImpl"
    }
}