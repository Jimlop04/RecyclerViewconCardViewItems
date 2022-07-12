package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.databinding.ActivityPantallaRevistasBinding

class pantalla_revistas : AppCompatActivity() {

    lateinit var binding: ActivityPantallaRevistasBinding
    private var adapter: adapter_revistas = adapter_revistas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setIcon(R.drawable.uteqlogo);

        binding = ActivityPantallaRevistasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var lstRevistas = ArrayList<class_revistas>()

        val ListarRevistas = Volley.newRequestQueue(this)
        val intent = intent.extras
        var url = "https://revistas.uteq.edu.ec/ws/journals.php"


        val ConsultaJSON = JsonArrayRequest(
            Request.Method.GET, url, null,
            { responseJson ->

                    for (i in 0 until responseJson.length()){
                        var revista = responseJson.getJSONObject(i)
                        lstRevistas.add(class_revistas(revista))
                    }
                    binding.itemsRevistas.setHasFixedSize(true)
                    binding.itemsRevistas.layoutManager = LinearLayoutManager(this)
                    adapter.adapter_revistas(lstRevistas, this)
                    binding.itemsRevistas.adapter = adapter
            },
            { ErrorJson ->
                val text =  ErrorJson.toString()
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            })
        ListarRevistas.add(ConsultaJSON)



    }



    }
