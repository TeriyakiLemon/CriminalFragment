package com.example.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID
import kotlin.math.log

private const val TAG = "CrimeListViewModel"
class CrimeListViewModel : ViewModel() {
    private val crimeRepository = CrimeRespository.get()
    val crimes = mutableListOf<Crime>()

    init {
        Log.d(TAG, "Init starting")
        viewModelScope.launch {
            Log.d(TAG, "Coroutine launched")
            crimes += loadCrimes()
//            delay(5000)
//            for (i in 0 until 100) {
//                val crime = Crime(
//                    id = UUID.randomUUID(),
//                    title = "Crime #$i",
//                    date = Date(),
//                    isSolved = i % 2 == 0
//            )
//                crimes += crime
//        }
            Log.d(TAG, "Loading crimes finished")
        }
    }

    suspend fun loadCrimes(): List<Crime> {
//        val result = mutableListOf<Crime>()
//
//        delay(5000)
//        for (i in 0 until 100) {
//            val crime = Crime(
//                id = UUID.randomUUID(),
//                title = "Crime #$i",
//                date = Date(),
//                isSolved = i % 2 == 0
//            )
//            result += crime
//
//        }
//        return result
        return crimeRepository.getCrimes()

    }

}

