package dev.abdujabbor.homework25loginregistercontact.ui

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import dev.abdujabbor.homework25loginregistercontact.MyData
import dev.abdujabbor.homework25loginregistercontact.R
import dev.abdujabbor.homework25loginregistercontact.adapters.RvAdapter
import dev.abdujabbor.homework25loginregistercontact.databinding.ActivityListBinding
import dev.abdujabbor.homework25loginregistercontact.databinding.DialogBottomBinding
import dev.abdujabbor.homework25loginregistercontact.databinding.DialogBottomSheetBinding
import dev.abdujabbor.homework25loginregistercontact.db.MyDbHelper
import dev.abdujabbor.homework25loginregistercontact.models.User

class ListActivity : AppCompatActivity(), RvAdapter.RvClick {
    lateinit var adapter: RvAdapter
    lateinit var dbHelper: MyDbHelper
    lateinit var list: ArrayList<User>
    val binding by lazy { ActivityListBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dbHelper = MyDbHelper(this)
        list = dbHelper.getAllUsers()
        adapter = RvAdapter(list, this)
        binding.myrecyclerview.adapter = adapter


    }

    override fun editClick(user: User) {
        MyData.user = user
        val dialoger = DialogBottomBinding.inflate(layoutInflater)
        val dialog = BottomSheetDialog(this, R.style.BottomSheetStyle)
//        dialoger.name.text = "Name: " + user.name
//        dialoger.number.text = "Number: " + user.number
//        dialoger.userImage.setImageBitmap(BitmapFactory.decodeFile(user.image))
        dialog.setContentView(dialoger.root)
        dialog.dismissWithAnimation = true

        dialog.setCancelable(true)

//        dialoger.call.setOnClickListener {
//            val dialIntent = Intent(Intent.ACTION_DIAL)
//            dialIntent.data = Uri.parse("tel:" + user.number)
//            startActivity(dialIntent)
//        }
//        dialoger.sms.setOnClickListener {
//            val dialSms = Intent(Intent.ACTION_SEND)
//            dialSms.data = Uri.parse("smsto: " + user.number)
//            startActivity(dialSms)
//        }
        dialog.show()

    }
}