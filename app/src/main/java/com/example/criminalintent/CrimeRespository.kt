package com.example.criminalintent

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import database.CrimeDatabase
import java.util.UUID

private const val DATABASE_NAME ="crime-database"
class CrimeRespository private constructor(context: Context){
    private val database:CrimeDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            CrimeDatabase::class.java,
            DATABASE_NAME
        )
        .createFromAsset(DATABASE_NAME)
        .build()

    suspend fun getCrimes():List<Crime> = database.crimeDao().getCrimes()

    suspend fun getCrimes(id: UUID) : Crime = database.crimeDao().getCrime(id)
    companion object{
        private var INSTANT: CrimeRespository?= null

        fun initialize(context : Context){
            if(INSTANT == null){
                INSTANT = CrimeRespository(context)
            }
        }

        fun get():CrimeRespository{
            return INSTANT ?:
            throw java.lang.IllegalStateException("CrimeRepository must be initialized")
        }
    }
}