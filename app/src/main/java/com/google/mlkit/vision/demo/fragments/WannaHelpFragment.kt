package com.google.mlkit.vision.demo.fragments

import android.content.Intent
import android.os.Bundle
import android.service.controls.ControlsProviderService
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.mlkit.vision.demo.R
import com.google.mlkit.vision.demo.databinding.FragmentWannaHelpBinding
import com.razorpay.Checkout
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import org.json.JSONObject
import java.lang.Exception


class WannaHelpFragment : Fragment() , PaymentResultWithDataListener {

    lateinit var binding:FragmentWannaHelpBinding
    lateinit var amountEdit: EditText
    private lateinit var payBtn: Button
    private lateinit var amount:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentWannaHelpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amountEdit=view.findViewById(R.id.amountEdit)
        payBtn=view.findViewById(R.id.payBtn)

        payBtn.setOnClickListener {
            amount=amountEdit.text.toString().trim()

            if(amount.isEmpty())
                return@setOnClickListener

            startPayment(amount.toInt())
            binding.amountEdit.text?.clear()


        }
    }
    private fun startPayment(toInt: Int) {
        val checkout= Checkout()
        checkout.setKeyID("rzp_test_3AuRUq8vpYjZEG")
        try {
            val options= JSONObject()
            options.put("name","Sahayak CrowdFunding")
            options.put("description","Financially Helping the Unprivileged")
            options.put("image","https://cdn.razorpay.com/logos/J4aMpjoJsqnhRg_medium.png")

            options.put("theme.color","#eebaec")
            options.put("currency","INR")

            options.put("amount","${(amount.toInt()*100)}")

            options.put("prefill.email","bitwisor@gmail.com")
            options.put("prefill.contact","+918171301100")
            checkout.open(requireActivity(),options)


        }
        catch (e: Exception){
            Toast.makeText(context,"Error in Payment"+e.message, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }


    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        Toast.makeText(context, "Payment Success$p0", Toast.LENGTH_SHORT).show()
        var intent= Intent(context,HomeFragment::class.java)
        startActivity(intent)
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        Log.d(ControlsProviderService.TAG,"onPaymentError: $p0")
        Log.d(ControlsProviderService.TAG,"onPaymentError: $p1")

        Toast.makeText(context, "Payment not successful$p0 $p1", Toast.LENGTH_SHORT).show()
        requireActivity().finish()

    }

}