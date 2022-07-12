package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.CardviewRevistasBinding

class adapter_revistas : RecyclerView.Adapter<adapter_revistas.ViewHolder>(){

    var ListaRevistas: ArrayList<class_revistas> = ArrayList()
    lateinit var context: Context

    class ViewHolder(val binding: CardviewRevistasBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    fun adapter_revistas(listJournals: ArrayList<class_revistas>, mContext: Context){
        this.ListaRevistas = listJournals
        this.context = mContext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardviewRevistasBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemRevista = ListaRevistas.get(position)
        holder.binding.txtNombreRevista.text = itemRevista.revista_Name
        holder.binding.txtAbreviatura.text = itemRevista.revista_Abbreviation
        //Glide - Insertar imagen
        Glide.with(context).load(itemRevista.revista_Portada).into(holder.binding.imgRevista)

        holder.binding.informacionRevistas.setOnClickListener {
            val act = Intent(context.applicationContext, pantalla_volumenes::class.java)
            act.putExtra("revista", ListaRevistas[position])
            act.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.getApplicationContext().startActivity(act)
        }
    }

    override fun getItemCount(): Int {
        return ListaRevistas.size
    }


}