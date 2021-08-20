package com.nxt.ltday17.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nxt.ltday17.R
import com.nxt.ltday17.model.Match

class MatchAdapter(var listMatch: ArrayList<Match>) :
    RecyclerView.Adapter<MatchAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchAdapter.MyViewHolder, position: Int) {
        holder.tvName1.text = listMatch[position].doi1
        holder.tvName2.text = listMatch[position].doi2
        holder.tvKenh.text = listMatch[position].kenh
        holder.tvHour.text = listMatch[position].gio
        holder.tvDate.text = listMatch[position].ngay

        Glide.with(holder.itemView.context).load(listMatch[position].quocky1)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.drawable.error)
            .into(holder.imgDoi1)
        Glide.with(holder.itemView.context).load(listMatch[position].quocky2)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.drawable.error)
            .into(holder.imgDoi2)
    }

    override fun getItemCount(): Int {
        return listMatch.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvDate: TextView = view.findViewById(R.id.tv_ngay)
        var tvHour: TextView = view.findViewById(R.id.tv_gio)
        var tvKenh: TextView = view.findViewById(R.id.tv_kenh)
        var tvName1: TextView = view.findViewById(R.id.tv_doi1)
        var tvName2: TextView = view.findViewById(R.id.tv_doi2)
        var imgDoi1: ImageView = view.findViewById(R.id.img_doi1)
        var imgDoi2: ImageView = view.findViewById(R.id.img_doi2)
    }
}