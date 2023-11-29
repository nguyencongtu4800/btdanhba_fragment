package com.example.btdanhba_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ContactDetailFragment : Fragment() {

    private lateinit var tvContactName: TextView
    private lateinit var tvContactPhoneNumber: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact_detail, container, false)

        // Initialize TextViews
        tvContactName = view.findViewById(R.id.tvContactName)
        tvContactPhoneNumber = view.findViewById(R.id.tvContactPhoneNumber)

        // Retrieve contact details from arguments (assuming you pass data through arguments)
        val contactName = arguments?.getString(ARG_CONTACT_NAME)
        val contactPhoneNumber = arguments?.getString(ARG_CONTACT_PHONE_NUMBER)

        // Display contact details in TextViews
        tvContactName.text = contactName
        tvContactPhoneNumber.text = contactPhoneNumber

        return view
    }

    companion object {
        // Constants for argument keys
        const val ARG_CONTACT_NAME = "contact_name"
        const val ARG_CONTACT_PHONE_NUMBER = "contact_phone_number"

        // Factory method to create a new instance of ContactDetailFragment
        fun newInstance(contact: Contact): ContactDetailFragment {
            val fragment = ContactDetailFragment()
            val args = Bundle()
            args.putString(ARG_CONTACT_NAME, contact.name.toString())
            args.putString(ARG_CONTACT_PHONE_NUMBER, contact.phoneNumber)
            fragment.arguments = args
            return fragment
        }
    }
}
