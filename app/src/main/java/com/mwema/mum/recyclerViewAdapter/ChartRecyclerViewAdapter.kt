package com.mwema.mum.recyclerViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mwema.mum.R
import com.mwema.mum.dto.SymptomLogDTO

class ChartRecyclerViewAdapter(var list: List<SymptomLogDTO>) : RecyclerView.Adapter<ChartRecyclerViewAdapter.ChartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.db_layout,parent,false)
        return ChartViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) {
        var data: SymptomLogDTO = list[position]
        holder.date_txtview.text = data.date
        holder.canMove_txtview.text = ( if (data.canMove) "can move" else "no movement")
        holder.notes_txtview.text= data.notes
        holder.painLevel_txtview.text =data.painLevel.toString()
    }

    override fun getItemCount(): Int = list.size

    class ChartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date_txtview: TextView = itemView.findViewById<TextView>(R.id.date)!!
        val canMove_txtview: TextView = itemView.findViewById<TextView>(R.id.can_move)!!
        val notes_txtview: TextView = itemView.findViewById<TextView>(R.id.notes)!!
        val painLevel_txtview: TextView = itemView.findViewById<TextView>(R.id.pain_level)!!
    }
}