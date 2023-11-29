package com.example.btdanhba_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity(), ItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the toolbar (optional)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Load ContactListFragment by default
        if (savedInstanceState == null) {
            showContactList()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.optionmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add_contact -> {
                // Gọi phương thức hiển thị Fragment thêm danh bạ
                showAddContact()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
    override fun itemClicked(contact: Contact) {
        showContactDetail(contact)
    }

// Replace current fragment with ContactListFragment
    fun showContactList() {
        val contactListFragment = ContactListFragment()
        replaceFragment(contactListFragment)
    }

    // Replace current fragment with AddContactFragment
    fun showAddContact() {
        val addContactFragment = AddContactFragment()
        replaceFragment(addContactFragment)
    }

    // Replace current fragment with ContactDetailFragment
    fun showContactDetail(contact: Contact) {
        val contactDetailFragment = ContactDetailFragment.newInstance(contact)
        replaceFragment(contactDetailFragment)
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}




