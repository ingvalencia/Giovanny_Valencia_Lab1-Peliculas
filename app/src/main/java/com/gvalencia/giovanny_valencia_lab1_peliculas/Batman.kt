package com.gvalencia.giovanny_valencia_lab1_peliculas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.fragment.app.Fragment

class Batman : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_batman, container, false)

        val vidBatman = view.findViewById<VideoView>(R.id.videoBatman)

        vidBatman.setVideoPath("android.resource://"+ (context?.packageName ?:null) +"/"+ R.raw.batman)

        val mcBatman: MediaController = MediaController(requireContext())
        mcBatman.setAnchorView(vidBatman)
        vidBatman.setMediaController(mcBatman)

        Toast.makeText(requireContext(), "Video Completado.",
            Toast.LENGTH_SHORT).show()

        return view
    }

}