package com.codingblocks.samplenotemakingappwithroom.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class Notes {
    @PrimaryKey(autoGenerate = true)
    val NOTEID: Int = 1
    val TITLE: String? = null
    val SUBTITLE: String? = null

}