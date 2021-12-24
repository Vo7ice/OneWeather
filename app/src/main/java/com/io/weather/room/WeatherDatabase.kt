package com.io.weather.room

import android.content.Context
import android.os.strictmode.InstanceCountViolation
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.io.weather.room.dao.CityInfoDao
import com.io.weather.room.entity.CityInfo

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-23
 */
@Database(
    entities = [CityInfo::class],
    version = 1
)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun cityInfoDao(): CityInfoDao

    companion object {

        // 多线程保护
        @Volatile
        private var INSTANCE: WeatherDatabase? = null

        fun getDatabase(context: Context): WeatherDatabase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null)
                return tmpInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    "weather_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}