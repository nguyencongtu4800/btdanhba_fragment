package com.example.btdanhba_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddContactFragment : Fragment() {

    private lateinit var etName: EditText
    private lateinit var etPhoneNumber: EditText
    private lateinit var btnAddContact: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_contact, container, false)

        etName = view.findViewById(R.id.etname)
        etPhoneNumber = view.findViewById(R.id.etphoneNumber)
        btnAddContact = view.findViewById(R.id.btnaddContact)

        btnAddContact.setOnClickListener {
            addContact()
        }

        return view
    }

    private fun addContact() {
        val name = etName.text.toString().trim()
        val phoneNumber = etPhoneNumber.text.toString().trim()

        if (name.isNotEmpty() && phoneNumber.isNotEmpty()) {
            // Add logic to save the contact to the data source (e.g., database)
            // You can implement this part based on your application's architecture

            // Show a success message
            Toast.makeText(context, "Contact added successfully", Toast.LENGTH_SHORT).show()

            // Optionally, navigate back to the contact list or perform other actions
            // For example, you can use the following code if MainActivity has a method showContactList()
            // (uncomment the next line and replace with the actual method name)
            // (activity as? MainActivity)?.showContactList()

        } else {
            // Show an error message if name or phone number is empty
            Toast.makeText(context, "Please enter name and phone number", Toast.LENGTH_SHORT).show()
        }
    }
}
