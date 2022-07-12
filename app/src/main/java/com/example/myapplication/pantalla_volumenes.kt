package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.databinding.ActivityPantallaVolumenesBinding

class pantalla_volumenes : AppCompatActivity() {
    lateinit var binding: ActivityPantallaVolumenesBinding
    private var adapter: adapter_volumen = adapter_volumen()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setIcon(R.drawable.uteqlogo);

        binding = ActivityPantallaVolumenesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datosRevista = intent.getSerializableExtra("revista") as class_revistas

        val lstVolumenes = ArrayList<class_Volumen>()

        val ListarVolumenes = Volley.newRequestQueue(this)
        var url= " https://revistas.uteq.edu.ec/ws/issues.php"

        val ConsultaJSON  = JsonArrayRequest(
            Request.Method.GET,url + "?j_id=" + datosRevista.revista_id,
            null,
            { responseJson ->

                    for (i in 0 until responseJson.length()){
                        var volumen = responseJson.getJSONObject(i)
                        lstVolumenes.add(class_Volumen(volumen))
                    }
                    binding.itemsVolumenes.setHasFixedSize(true)
                    binding.itemsVolumenes.layoutManager = LinearLayoutManager(this)
                    adapter.adapter_volumen(lstVolumenes, this)
                    binding.itemsVolumenes.adapter = adapter
                    binding.Tvolumenes.text = datosRevista.revista_Name
                },
            { ErrorJson ->
                val text =  ErrorJson.toString()
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
            )
        ListarVolumenes.add(ConsultaJSON )

    }
}