package com.example.myapplication

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class class_autor (aut: JSONObject){
    var autor_nombres : String
    var autor_filiacion : String
    var autor_email : String

    companion object {
        @Throws(JSONException::class)
        fun JsonObjectsBuild(datos: JSONArray) : ArrayList<class_autor> {
            val authors : ArrayList<class_autor> = ArrayList<class_autor>()
            for(i in 0 until datos.length()){
                authors.add(class_autor(datos.getJSONObject(i)))
            }
            return authors
        }
    }

    init {
        autor_nombres = aut.getString("nombres")
        autor_filiacion = aut.getString("filiacion")
        autor_email = aut.getString("email")
    }
}