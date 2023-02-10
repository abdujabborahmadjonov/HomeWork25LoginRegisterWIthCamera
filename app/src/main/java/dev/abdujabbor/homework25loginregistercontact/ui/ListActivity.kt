package dev.abdujabbor.homework25loginregistercontact.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import dev.abdujabbor.homework25loginregistercontact.MyData
import dev.abdujabbor.homework25loginregistercontact.R
import dev.abdujabbor.homework25loginregistercontact.adapters.RvAdapter
import dev.abdujabbor.homework25loginregistercontact.databinding.ActivityListBinding
import dev.abdujabbor.homework25loginregistercontact.databinding.ActivityLoginBinding
import dev.abdujabbor.homework25loginregistercontact.databinding.DialogBottomSheetBinding
import dev.abdujabbor.homework25loginregistercontact.db.MyDbHelper
import dev.abdujabbor.homework25loginregistercontact.models.User

class ListActivity : AppCompatActivity(),RvAdapter.RvClick {
    lateinit var adapter: RvAdapter
    lateinit var dbHelper: MyDbHelper
    lateinit var list: ArrayList<User>
    val binding by lazy { ActivityListBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dbHelper = MyDbHelper(this)
        list = dbHelper.getAllUsers()
        adapter = RvAdapter(list,this)
        binding.myrecyclerview.adapter = adapter


    }

    override fun editClick(user: User) {
        MyData.user = user
       val dialog = BottomSheetDialog(this,R.style.BottomSheetStyle)
        dialog.setContentView(DialogBottomSheetBinding.inflate(layoutInflater).root)
        dialog.dismissWithAnimation = true
        dialog.setCancelable(true)
        dialog.show()

    }
}