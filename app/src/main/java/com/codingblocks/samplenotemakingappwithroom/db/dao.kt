package com.codingblocks.samplenotemakingappwithroom.db

import android.arch.persistence.room.*
import com.codingblocks.samplenotemakingappwithroom.Note


@Dao
interface NoteDao {
    @Query("SELECT * FROM Notes")
    fun getAllNotes(): List<Notes>

    @Insert
    fun insert(vararg notes: Note)

    @Update
    fun update(vararg notes: Notes)

    @Delete
    fun delete(vararg notes: Notes)

}