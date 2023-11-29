package com.example.btdanhba_fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var contactsList: List<Contact>): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private var onItemClickListener: ((Contact) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)

        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        holder.tvname.text = contactsList[position].name
        holder.tvphonenumber.text = contactsList[position].phoneNumber

        // Xử lý sự kiện khi chọn một đối tượng trên danh sách
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(contactsList[0])
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    // Thiết lập danh sách danh bạ
    fun setContacts(contacts: List<Contact>) {
        this.contactsList = contacts
        notifyDataSetChanged()
    }

    // Thiết lập lắng nghe sự kiện khi chọn một đối tượng trên danh sách
    fun setOnItemClickListener(listener: (Contact) -> Unit) {
        this.onItemClickListener = listener
    }

    // Lớp ViewHolder
    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvname: TextView
        val tvphonenumber: TextView
        init {
            tvname= itemView.findViewById(R.id.tvName)
            tvphonenumber= itemView.findViewById(R.id.tvPhoneNumber)
        }
    }
}
