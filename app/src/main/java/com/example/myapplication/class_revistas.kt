package com.example.myapplication

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable

class class_revistas (rev: JSONObject) : Serializable {

    var revista_id : String
    var revista_Name : String
    var revista_Abbreviation : String
    var revista_Description : String
    var revista_Portada : String
    var revista_Thumbnail : String

    companion object {
        @Throws(JSONException::class)
        fun JsonObjectsBuild(datos: JSONArray): ArrayList<class_Volumen> {
            val revistas : ArrayList<class_Volumen> =  ArrayList<class_Volumen>()
            for(i in 0 until datos.length()) {
                revistas.add(class_Volumen(datos.getJSONObject(i)))
            }
            return revistas
        }
    }

    init {
        revista_id = rev.getString("journal_id").toString()
        revista_Name = rev.getString("name").toString()
        revista_Abbreviation = rev.getString("abbreviation").toString()
        revista_Description = rev.getString("description").toString()
        revista_Portada = rev.getString("portada").toString()
        revista_Thumbnail = rev.getString("journalThumbnail").toString()
    }


}