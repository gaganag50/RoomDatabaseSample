package com.codingblocks.samplenotemakingappwithroom

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.codingblocks.samplenotemakingappwithroom.db.NoteDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainAct"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<Note>()
        val adapter = NoteAdapter(list)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter


        btnSave.setOnClickListener {

            val title = etTitle.text.toString()
            val subTitle = etSubTitle.text.toString()
            list.add(Note(title, subTitle))
            Log.d(TAG, """
                title: ${title}
                subTitle ${subTitle}
            """.trimIndent())

            adapter.notifyDataSetChanged()
        }
        Thread {
            NoteDatabase
                    .getInstance(this@MainActivity)?.getNoteDao()?.insert(Note("Cool", "url"))


//            Getting things

            val allNotes = NoteDatabase
                    .getInstance(context = this@MainActivity)?.getNoteDao()?.getAllNotes()


            Log.d(TAG, ": all Notes are: " + allNotes?.toList().toString())

        }.start()

    }


}
