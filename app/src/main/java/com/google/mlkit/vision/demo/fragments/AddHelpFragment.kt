package com.google.mlkit.vision.demo.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.mlkit.vision.demo.R
import com.google.mlkit.vision.demo.databinding.FragmentAddHelpBinding
import com.google.mlkit.vision.demo.model.Helpdesk_Model


class AddHelpFragment : Fragment() {

    lateinit var binding:FragmentAddHelpBinding
    lateinit var grievanceTitle: EditText
    lateinit var grievanceDesc: EditText
    lateinit var pushGrievance: Button

    lateinit var helpDbref: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddHelpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        grievanceTitle=view.findViewById(R.id.grievanceTitle)
        grievanceDesc=view.findViewById(R.id.grievanceDescription)
        pushGrievance=view.findViewById(R.id.sendHelp)

        pushGrievance.setOnClickListener {

            insertGrievance()

        }

        helpDbref= FirebaseDatabase.getInstance().reference.child("Help")

    }
    private fun insertGrievance() {
        var Title:String=grievanceTitle.text.toString()
        var Description=grievanceDesc.text.toString()

        var model:Helpdesk_Model= Helpdesk_Model(Title,Description)
        if(TextUtils.isEmpty(Title) || TextUtils.isEmpty(Description))
        {
            Toast.makeText(context, "Please Enter all the necessary details", Toast.LENGTH_SHORT).show()
            return
        }

        else{
            helpDbref.push().setValue(model)
            grievanceTitle.setText("")
            grievanceDesc.setText("")
            Toast.makeText(context, "Thanks for Registering in our HelpDesk portal....A Volunteer will contact you as soon as possible", Toast.LENGTH_SHORT).show()
        }
    }

}