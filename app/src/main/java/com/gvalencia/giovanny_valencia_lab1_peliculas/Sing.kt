package com.gvalencia.giovanny_valencia_lab1_peliculas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.fragment.app.Fragment


class Sing : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sing, container, false)

        val vidSing = view.findViewById<VideoView>(R.id.videoSing)

        vidSing.setVideoPath("android.resource://"+ (context?.packageName ?:null) +"/"+ R.raw.sing)

        val mcSing: MediaController = MediaController(requireContext())
        mcSing.setAnchorView(vidSing)
        vidSing.setMediaController(mcSing)

        Toast.makeText(requireContext(), "Video Completado.",
            Toast.LENGTH_SHORT).show()

        return view
    }


}