package kr.ac.seokyeong.on_line_chatting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kr.ac.seokyeong.on_line_chatting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var array : MutableList<UserDTO> = arrayListOf()
    var uids : MutableList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        FirebaseFirestore.getInstance().collection("users").get().addOnCompleteListener {
            task ->
            array.clear()
            uids.clear()

            for (item in task.result!!.documents) {
                array.add(item.toObject(UserDTO::class.java)!!)
                uids.add(item.id)
            }
            binding.peopleListRecyclerview.adapter?.notifyDataSetChanged()
        }
        binding.peopleListRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.peopleListRecyclerview.adapter = RecyclerviewAdapter()
    }

    inner class RecyclerviewAdapter : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewAdapter.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerviewAdapter.ViewHolder, position: Int) {
            holder.itemEmail.text = array[position].email
        }

        override fun getItemCount(): Int {
            return array.size
        }

        inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val itemEmail = view.findViewById<TextView>(R.id.item_email)
        }

    }
}