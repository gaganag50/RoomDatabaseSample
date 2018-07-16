package com.codingblocks.samplenotemakingappwithroom.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = [(Notes::class)], version = 1)
abstract class NoteDatabase : RoomDatabase() {


    //    getInstance() method which is nothing more than a simple singleton pattern.
    //    […] each RoomDatabase instance is fairly expensive, and you rarely need access to multiple instances.

    companion object {
        private val DB_NAME = "noteDatabase.db"


        @Volatile
        private var instance: NoteDatabase? = null

        @Synchronized
        internal fun getInstance(context: Context): NoteDatabase? {
            if (instance == null) {
                instance = create(context)
            }
            return instance

        }

        private fun create(context: Context): NoteDatabase {
            return Room.databaseBuilder(
                    context,
                    NoteDatabase::class.java,
                    DB_NAME).build()
        }

    }

    abstract fun getNoteDao(): NoteDao


//    static create() method, where we create our database by passing Context, database class, and name.


//    database class should have these things at the minimum:
//    @Database annotation
//    class to be abstract and extend from RoomDatabase class
//    class have an abstract method with no parameters and returns the class that is annotated with @Dao


}