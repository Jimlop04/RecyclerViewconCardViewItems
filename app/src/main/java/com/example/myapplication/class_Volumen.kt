package com.example.myapplication

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable

class class_Volumen (vol: JSONObject) : Serializable {
    var vol_issueID : String
    var vol_volumen : String
    var vol_number : String
    var vol_year : String
    var vol_datePublished : String
    var vol_title : String
    var vol_doi : String
    var vol_cover : String

    companion object {
        @Throws(JSONException::class)
        fun JsonObjectsBuild(datos: JSONArray): ArrayList<class_Volumen> {
            val volumes : ArrayList<class_Volumen> =  ArrayList<class_Volumen>()
            for(i in 0 until datos.length()) {
                volumes.add(class_Volumen(datos.getJSONObject(i)))
            }
            return volumes
        }
    }

    init {
        vol_issueID = vol.getString("issue_id").toString()
        vol_volumen = vol.getString("volume").toString()
        vol_number = vol.getString("number").toString()
        vol_year = vol.getString("year").toString()
        vol_datePublished = vol.getString("date_published").toString()
        vol_title = vol.getString("title").toString()
        vol_doi = vol.getString("doi").toString()
        vol_cover = vol.getString("cover").toString()
    }
}