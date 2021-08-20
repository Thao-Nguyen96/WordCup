package com.nxt.ltday17.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nxt.ltday17.R
import com.nxt.ltday17.model.Player

class PlayerAdapter(var listPlayer: ArrayList<Player>) :
    RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerAdapter.MyViewHolder, position: Int) {
        holder.tvTen.text = listPlayer[position].ten
        holder.tvDoi.text = listPlayer[position].doi
        holder.tvSocial.text = listPlayer[position].social
        Glide.with(holder.itemView.context).load(listPlayer[position].image)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.drawable.error)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return listPlayer.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTen: TextView = itemView.findViewById(R.id.tv_name_cau_thu)
        var tvSocial: TextView = itemView.findViewById(R.id.tv_view_social)
        var tvDoi: TextView = itemView.findViewById(R.id.tv_doi_cau_thu)
        var image: ImageView = itemView.findViewById(R.id.img_image_cau_thu)
    }
}