package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.databinding.ActivityPantallaArticulosBinding

class pantalla_articulos : AppCompatActivity() {

    lateinit var binding: ActivityPantallaArticulosBinding
    private var adapter : adapter_articulos = adapter_articulos()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setIcon(R.drawable.uteqlogo);

        binding = ActivityPantallaArticulosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datosVolumen = intent.getSerializableExtra("volumen") as class_Volumen
        val lstArticulos = ArrayList<class_articulos>()
        val ListarArticulos = Volley.newRequestQueue(this)
        var url=" https://revistas.uteq.edu.ec/ws/pubs.php"

        val ConsultaJSON = JsonArrayRequest(
            Request.Method.GET, url + "?i_id=" + datosVolumen.vol_issueID, null,
            { responseJson ->

                    for (i in 0 until responseJson.length()){
                        var articulo = responseJson.getJSONObject(i)
                        lstArticulos.add(class_articulos(articulo))
                    }
                    binding.itemsArticulos.setHasFixedSize(true)
                    binding.itemsArticulos.layoutManager = LinearLayoutManager(this)
                    adapter.adapter_articulos(lstArticulos, this)
                    binding.itemsArticulos.adapter = adapter
                    binding.Tarticulos.text = "Vol. " + datosVolumen.vol_volumen +
                            " Num. " + datosVolumen.vol_number + ":\n" +
                            "Revista Ciencias y Tecnología "
            },
            { ErrorJson ->
                val text =  ErrorJson.toString()
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            })
        ListarArticulos.add(ConsultaJSON)

    }
}