package com.nineworldsdeep.synergy

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import android.arch.persistence.db.SupportSQLiteDatabase
import android.support.annotation.NonNull



@Database(entities = arrayOf(SynergyItem::class), version = 1)
abstract class SynergyRoomDatabase : RoomDatabase() {

    abstract fun synergyItemDao(): SynergyItemDao

    companion object {
        private var INSTANCE: SynergyRoomDatabase? = null

        fun getDatabase(context: Context): SynergyRoomDatabase? {
            if(INSTANCE == null){
                synchronized(SynergyRoomDatabase::class){
                    if(INSTANCE == null){
                       INSTANCE = Room.databaseBuilder(context.applicationContext,
                               SynergyRoomDatabase::class.java, "synergy_database")
                               .addCallback(object : RoomDatabase.Callback() {

                                   override fun onOpen(db: SupportSQLiteDatabase) {
                                       super.onOpen(db)
                                       PopulateDbAsync(INSTANCE!!).execute()
                                   }
                               })
                               .build()
                    }
                }
            }
            return INSTANCE
        }
    }

    private class PopulateDbAsync internal constructor(db: SynergyRoomDatabase) : AsyncTask<Void, Void, Void>() {

        private val mDao: SynergyItemDao

        init {
            mDao = db.synergyItemDao()
        }

        override fun doInBackground(vararg params: Void): Void? {
            mDao.deleteAll()
            var synergyItem = SynergyItem("lst-s8-1", "List Name Goes Here", "Internal List", "[timestamp goes here]")
            mDao.insert(synergyItem)
            synergyItem = SynergyItem("s8-2", "a list item", "Raw Text", "[timestamp goes here]")
            mDao.insert(synergyItem)
            return null
        }
    }
}