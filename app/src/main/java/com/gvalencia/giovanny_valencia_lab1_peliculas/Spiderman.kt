package com.gvalencia.giovanny_valencia_lab1_peliculas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.fragment.app.Fragment


class Spiderman : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_spiderman, container, false)

        val vidSpiderman = view.findViewById<VideoView>(R.id.videoSpiderman)

        vidSpiderman.setVideoPath("android.resource://"+ (context?.packageName ?:null) +"/"+ R.raw.spiderman)

        val mcspiderman: MediaController = MediaController(requireContext())
        mcspiderman.setAnchorView(vidSpiderman)
        vidSpiderman.setMediaController(mcspiderman)

        Toast.makeText(requireContext(), "Video Completado.",
            Toast.LENGTH_SHORT).show()

        return view
    }


}