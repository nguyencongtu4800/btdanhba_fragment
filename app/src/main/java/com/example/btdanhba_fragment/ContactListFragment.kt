package com.example.btdanhba_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


private fun Bundle.putSerializable(s: String, contact: Contact) {

}

class ContactListFragment : Fragment() {

    // Khai báo RecyclerView và Adapter
    val contactsList: List<Contact> = listOf(
        Contact("John Doe", "123-456-7890"),
        Contact("Jane Smith", "987-654-3210"),
        Contact("Alice Johnson", "555-123-4567"),
        Contact("Bob Williams", "333-888-9999"),
        Contact("Eva Davis", "777-555-1234"),
        // Thêm nhiều Contact khác nếu cần thiết
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_View)
        val adapter = ContactAdapter(contactsList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter


        // Xử lý sự kiện khi chọn một đối tượng trên danh sách
        fun showContactDetail(contact: Contact) {
            val contactDetailFragment = ContactDetailFragment()

            // Truyền dữ liệu chi tiết danh bạ vào fragment
            val bundle = Bundle()
            bundle.putSerializable("contact", contact)
            contactDetailFragment.arguments = bundle

            // Thay thế fragment hiện tại bằng fragment chi tiết
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, contactDetailFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}
