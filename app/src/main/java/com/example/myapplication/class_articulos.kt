package com.example.myapplication

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable

class class_articulos (art: JSONObject) : Serializable {
    var art_section : String
    var art_publicationID : String
    var art_title : String
    var art_doi : String
    var art_abstract : String
    var art_datePublished : String
    var art_submissionID : String
    var art_sectionID : String
    var art_seq : String
    var art_galeys : String? = null
    var art_keywords : ArrayList<String>
    var art_authors : ArrayList<class_autor>

    companion object {
        @Throws(JSONException::class)
        fun JsonObjectsBuild(datos: JSONArray): ArrayList<class_articulos> {
            val articles : ArrayList<class_articulos> =  ArrayList<class_articulos>()
            for(i in 0 until datos.length()) {
                articles.add(class_articulos(datos.getJSONObject(i)))
            }
            return articles
        }
    }

    init {
        art_section = art.getString("section").toString()
        art_publicationID = art.getString("publication_id").toString()
        art_title = art.getString("title").toString()
        art_doi = art.getString("doi").toString()
        art_abstract = art.getString("abstract").toString()
        art_datePublished = art.getString("date_published").toString()
        art_submissionID = art.getString("submission_id").toString()
        art_sectionID = art.getString("section_id").toString()
        art_seq = art.getString("seq").toString()
        art_galeys = art.getString("galeys")!!.toString()
        art_keywords = ArrayList<String>()
        val arrayKeywords = art.getJSONArray("keywords")
        for (i in 0 until arrayKeywords.length()){
            art_keywords.add(arrayKeywords.getJSONObject(i).getString("keyword"))
        }
        art_authors = ArrayList<class_autor>()
        art_authors = class_autor.JsonObjectsBuild(art.getJSONArray("authors"))
    }

}