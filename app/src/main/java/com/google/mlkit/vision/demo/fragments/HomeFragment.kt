package com.google.mlkit.vision.demo.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.google.mlkit.vision.demo.R
import com.google.mlkit.vision.demo.databinding.FragmentHomeBinding
import com.google.mlkit.vision.demo.kotlin.CameraXSourceDemoActivity
import com.google.mlkit.vision.demo.shake.ShakeWorker


class HomeFragment : Fragment() {


    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uploadWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<ShakeWorker>()
                .build()
        WorkManager
            .getInstance(requireContext())
            .enqueue(uploadWorkRequest)
        binding.locatenow.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mapFragment)
        }

        binding.menuy.setOnClickListener {
            val i = Intent(requireActivity(), CameraXSourceDemoActivity::class.java)
            startActivity(i)
        }
        binding.notificationbellllll.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_helpDeskFragment)
        }
        binding.textToSpeech.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_textWriterFragment)
        }

        binding.actionsTextToSpeech.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_actionFragment)
        }
        binding.mallcard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mallsFragment)
        }
        binding.hospitalscard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_hospitalsFragment)
        }
        binding.librarycard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_libraryFragment)
        }
        binding.bankscard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_banksFragment)
        }
        binding.restaurantcard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_restroFragment)
        }

        binding.toiletcard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_toiletsFragment)
        }
        binding.help.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addHelpFragment)
        }
        binding.goiExplore.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_ministryOfDisabledWebViewFragment)
        }
        binding.crutchy.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_crutchFragment)
        }
        binding.wheely.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_wheelChairFragment)
        }
        binding.helpuuu.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_helperFragment)
        }
        binding.donatecard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_wannaHelpFragment)
        }
        binding.actionsSpeechToTxt.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_speechtoTextFragment)
        }
    }
}