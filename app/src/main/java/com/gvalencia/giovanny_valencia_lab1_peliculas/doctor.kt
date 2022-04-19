package com.gvalencia.giovanny_valencia_lab1_peliculas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.fragment.app.Fragment


class doctor : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_doctor, container, false)

        val vidDoctor = view.findViewById<VideoView>(R.id.videoDoctor)

        vidDoctor.setVideoPath("android.resource://"+ (context?.packageName ?:null) +"/"+ R.raw.doctor)

        val mcDoctor: MediaController = MediaController(requireContext())
        mcDoctor.setAnchorView(vidDoctor)
        vidDoctor.setMediaController(mcDoctor)

        Toast.makeText(requireContext(), "Video Completado.",
            Toast.LENGTH_SHORT).show()

        return view
    }


}