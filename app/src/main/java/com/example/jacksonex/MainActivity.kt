package com.example.jacksonex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper

class MainActivity : AppCompatActivity() {

    data class NameContainer(@JsonProperty("name") val name: String)

    lateinit var objectMapper: ObjectMapper

    private val json = """{"name":"HELLO"}"""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonView = findViewById<TextView>(R.id.textViewJson)
        val stringView = findViewById<TextView>(R.id.textViewToString)

        objectMapper = ObjectMapper()

        jsonView.text = json

        val nameContainer = objectMapper.readValue(json, NameContainer::class.java)

        stringView.text = nameContainer.toString()
    }
}
