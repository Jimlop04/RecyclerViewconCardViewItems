package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardviewArticulosBinding

class adapter_articulos : RecyclerView.Adapter<adapter_articulos.ViewHolder>() {

    var ListaArticulos: ArrayList<class_articulos> = ArrayList()
    lateinit var context: Context

    class ViewHolder(val binding: CardviewArticulosBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    fun adapter_articulos(listArticles: ArrayList<class_articulos>, mContext: Context){
        this.ListaArticulos = listArticles
        this.context = mContext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardviewArticulosBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemArticulo = ListaArticulos.get(position)
        holder.binding.txtTituloArticulo.text = itemArticulo.art_title
        holder.binding.txtDoiArticulo.text = itemArticulo.art_doi
        holder.binding.txtFechaArticulo.text = itemArticulo.art_datePublished
    }

    override fun getItemCount(): Int {
        return ListaArticulos.size
    }
}