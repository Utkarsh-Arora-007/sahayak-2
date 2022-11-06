package com.google.mlkit.vision.demo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.mlkit.vision.demo.R
import com.google.mlkit.vision.demo.adapter.GrievanceShowAdapter
import com.google.mlkit.vision.demo.databinding.FragmentHelpDeskBinding
import com.google.mlkit.vision.demo.model.Helpdesk_Model


class HelpDeskFragment : Fragment() {

    private lateinit var binding:FragmentHelpDeskBinding
    lateinit var recyclerView: RecyclerView
    lateinit var reference: DatabaseReference
    lateinit var grievanceBtn: ImageView
    lateinit var grievanceShowAdapter: GrievanceShowAdapter
    lateinit var list: ArrayList<Helpdesk_Model>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHelpDeskBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.HelpDeskRecyclerView)
        reference= FirebaseDatabase.getInstance().getReference("Help")
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        list= ArrayList()
        grievanceShowAdapter = GrievanceShowAdapter(context, list)
        recyclerView.adapter = grievanceShowAdapter
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    val helpdesk_model: Helpdesk_Model? = dataSnapshot.getValue(
                        Helpdesk_Model::class.java
                    )
                    list.add(helpdesk_model!!)

                }
                grievanceShowAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {}
        })

    }

}