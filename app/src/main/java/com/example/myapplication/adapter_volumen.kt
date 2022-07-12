package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.CardviewVolumenesBinding

class adapter_volumen : RecyclerView.Adapter<adapter_volumen.ViewHolder>(){
    var ListaVolumenes: ArrayList<class_Volumen> = ArrayList()
    lateinit var context: Context

    class ViewHolder(val binding: CardviewVolumenesBinding  ) : RecyclerView.ViewHolder(binding.root) {
    }

    fun adapter_volumen(listVolumes: ArrayList<class_Volumen>, mContext: Context){
        this.ListaVolumenes = listVolumes
        this.context = mContext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardviewVolumenesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemVolume = ListaVolumenes.get(position)
        holder.binding.txtVolumenDescription.text = "Vol. " + itemVolume.vol_volumen +
                " Num. " + itemVolume.vol_number
        holder.binding.txtDoi.text = "Doi: " + itemVolume.vol_doi
        holder.binding.txtFechaPublicado.text = "Publicado: " + itemVolume.vol_datePublished
        //Cargar imagen con Glide
        Glide.with(context).load(itemVolume.vol_cover).into(holder.binding.imgVolumen)

        holder.binding.informacionVolumen.setOnClickListener {
            val act = Intent(context.applicationContext, pantalla_articulos::class.java)
            act.putExtra("volumen", ListaVolumenes[position])
            act.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.getApplicationContext().startActivity(act)
        }
    }

    override fun getItemCount(): Int {
        return ListaVolumenes.size
    }


}