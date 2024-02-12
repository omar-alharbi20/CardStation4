package com.example.cardstation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //  val imageList = mutableListOf<Int>()
        // imageList.add(R.drawable.img_5)
        // imageList.add(R.drawable.img_2)

        // val imageView1 = view.findViewById<ImageView>(R.id.imag5)
        // val imageView2 = view.findViewById<ImageView>(R.id.imag2)
        // val imageView3 = view.findViewById<ImageView>(R.id.imag4)
        // val imageView4 = view.findViewById<ImageView>(R.id.imag11)


        // imageView1.setOnClickListener {
        // val bundle = Bundle()
        //bundle.putInt("imageId", imageList[0])
        // val cartFragment = cartFragment()
        // cartFragment.arguments = bundle
        //activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.cart2, cartFragment)?.commit()
        //}

        /*imageView2.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("imageId", imageList[1])
            val cartFragment = cartFragment()
            cartFragment.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.cart2, cartFragment)?.commit()
        }*/

        return view
    }
}