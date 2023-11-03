package database

import androidx.room.TypeConverter
import java.util.Date

class CrimeTypeConverters {
    @TypeConverter
    fun fromDate(data: Date) :Long{
        return data.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch : Long): Date{
        return Date(millisSinceEpoch)
    }
}