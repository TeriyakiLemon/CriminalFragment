package com.example.criminalintent

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import database.CrimeDatabase
import kotlinx.coroutines.flow.Flow
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

     fun getCrimes():Flow<List<Crime>> = database.crimeDao().getCrimes()

    suspend fun getCrimes(id: UUID) : Crime = database.crimeDao().getCrime(id)
    companion object{
        private var INSTANCE: CrimeRespository?= null

        fun initialize(context : Context){
            if(INSTANCE == null){
                INSTANCE = CrimeRespository(context)
            }
        }

        fun get():CrimeRespository{
            return INSTANCE ?:
            throw java.lang.IllegalStateException("CrimeRepository must be initialized")
        }
    }
}