package com.example.cardstation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class cartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

       /* val imageView = view.findViewById<ImageView>(R.id.imageView2)
        val imageView1 = view.findViewById<ImageView>(R.id.imageView2)


        val imageId = arguments?.getInt("imageId")
        if (imageId != null) {
            imageView.setImageResource(imageId) // عرض الصورة في ImageView بشكل صحيح
        }
        val image1 = arguments?.getInt("imageId")
        if (image1 != null) {
            imageView1.setImageResource(image1) // عرض الصورة في ImageView بشكل صحيح
        }*/

        return view
    }
}