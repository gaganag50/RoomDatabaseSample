package com.codingblocks.samplenotemakingappwithroom

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NoteAdapter(val list: ArrayList<Note>) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val li = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.activity_show_list, parent, false)
        return NoteHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val note: Note = list[position]
        holder.bindView(note)
    }

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(note: Note) {
            itemView.findViewById<TextView>(R.id.tvTitle).text = note.title
            itemView.findViewById<TextView>(R.id.tvSubTitle).text = note.subTitle
        }

    }
}
