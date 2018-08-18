package com.cammykamal.kotlin.roomkotlinqueries.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.cammykamal.kotlin.roomkotlinqueries.models.StudentInfo


@Database(entities = arrayOf(StudentInfo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var APPDATABASE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (APPDATABASE == null) {
                synchronized(AppDatabase::class) {
                    APPDATABASE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase::class.java, "studentData.db").allowMainThreadQueries()
                            .build()
                }
            }
            return APPDATABASE
        }
    }


    abstract fun studentDao(): StudentDao
}
