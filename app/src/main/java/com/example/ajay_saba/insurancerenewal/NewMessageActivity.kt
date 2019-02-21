package com.example.ajay_saba.insurancerenewal

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_new_message.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.ajay_saba.insurancerenewal.R.layout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_latest_messages.*
import kotlinx.android.synthetic.main.layout_list_view.*
import kotlinx.android.synthetic.main.user_row_new_message.view.*


class NewMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_new_message)

        supportActionBar?.title = "Search User"


       /* val adapter = GroupAdapter<ViewHolder>()

        adapter.add(UserItem())
        adapter.add(UserItem())
        adapter.add(UserItem())
        recycler_view_new_message.adapter = adapter
*/

        fetchUsers()
        
    }
    companion object {
        val USER_KEY = "USER_KEY"
    }

    private fun fetchUsers(){
        val ref = FirebaseDatabase.getInstance().getReference("/POLICY NUMBER")
        ref.addListenerForSingleValueEvent(object : ValueEventListener{

            override fun onDataChange(p0: DataSnapshot) {
                val adapter= GroupAdapter<ViewHolder>()
                p0.children.forEach{
                    Log.d("NewMessage",it.toString())
                    val policy = it.getValue(Policy::class.java)
                    if (policy!=null)
                        adapter.add(UserItem(policy))
                }
                recycler_view_new_message.adapter = adapter

                adapter.setOnItemClickListener{item, view ->
                    val userItem = item as UserItem
                    val intent = Intent(view.context,ClientData::class.java)
                    intent.putExtra(USER_KEY,userItem.policy.clientname)
                    startActivity(intent)
                    finish()
                }

            }
            override fun onCancelled(p0: DatabaseError) {

            }
        })
    }
}

class UserItem(val policy : Policy) : Item<ViewHolder>(){
    override fun bind(viewHolder: ViewHolder, position: Int) {
        //called in List for each user obj later
        viewHolder.itemView.tvUsername.text = policy.clientname
        viewHolder.itemView.tvPolicyNumber.text = policy.policyno
        /*viewHolder.itemView.tvRenew.text=policy.renewaldate
        viewHolder.itemView.tvVehic.text=policy.vehicleno*/


    }

    override fun getLayout(): Int {
     return R.layout.user_row_new_message
    }
}

