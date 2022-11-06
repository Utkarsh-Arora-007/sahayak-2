package com.google.mlkit.vision.demo.fragments

import android.R.attr
import android.app.appsearch.AppSearchResult.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.mlkit.vision.demo.databinding.FragmentSpeechtoTextBinding
import java.util.*


class SpeechtoTextFragment : Fragment() {

    lateinit var binding:FragmentSpeechtoTextBinding
    private val RQ_SPEECH_REC = 102
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSpeechtoTextBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.speakbtn.setOnClickListener {
            speak()
        }

    }

    private fun speak(){
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
            Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak Something to Sahayak.")

        try {
            startActivityForResult(intent, RQ_SPEECH_REC)
        } catch (e: Exception) {
            Toast
                .makeText(requireContext(), " " + e.message,
                    Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("RES",data?.getStringArrayListExtra( RecognizerIntent.EXTRA_RESULTS).toString())

        binding.speechtotxttxt.text = data?.getStringArrayListExtra( RecognizerIntent.EXTRA_RESULTS)?.get(0).toString()
    }

}