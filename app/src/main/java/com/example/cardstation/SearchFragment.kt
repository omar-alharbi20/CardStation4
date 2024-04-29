package com.example.cardstation

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.cardstation.R

class SearchFragment : Fragment() {
    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var image4: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        searchEditText = view.findViewById(R.id.searchEditText)
        searchButton = view.findViewById(R.id.searchButton)
        image4 = view.findViewById(R.id.image4)
        image2 = view.findViewById(R.id.image2)
        image3 = view.findViewById(R.id.image3)




        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                when (s.toString().lowercase()) {

                    "google play", "g" -> {
                        image4.visibility = ImageView.GONE
                        image2.visibility = ImageView.VISIBLE
                        image3.visibility = ImageView.GONE
                    }

                    "xbox", "x" -> {
                        image4.visibility = ImageView.VISIBLE
                        image2.visibility = ImageView.GONE

                    }

                    "itunes", "i" -> {

                        image3.visibility = ImageView.GONE
                    }

                    "apple", "a" -> {
                        image4.visibility = ImageView.GONE
                        image2.visibility = ImageView.GONE
                        image3.visibility = ImageView.VISIBLE
                    }

                    else -> {
                        image4.visibility = ImageView.GONE
                        image2.visibility = ImageView.GONE
                        image3.visibility = ImageView.GONE
                    }
                }
            }
        })

        return view
    }
}