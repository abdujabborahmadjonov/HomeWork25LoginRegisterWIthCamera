package dev.abdujabbor.homework25loginregistercontact.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.widget.Toast
import dev.abdujabbor.homework25loginregistercontact.R
import dev.abdujabbor.homework25loginregistercontact.databinding.ActivityLoginBinding
import dev.abdujabbor.homework25loginregistercontact.db.MyDbHelper
import dev.abdujabbor.homework25loginregistercontact.models.User
import dev.abdujabbor.homework25loginregistercontact.models.Usercha

class LoginActivity : AppCompatActivity() {
    lateinit var dbHelper: MyDbHelper
    lateinit var list: ArrayList<Usercha>
    val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dbHelper = MyDbHelper(this)
        list = dbHelper.getAllUsercha()

        binding.login.setOnClickListener {
            if (list.contains(Usercha(binding.textUsername.text.toString(),binding.textPassword.text.toString()))){

                startActivity(Intent(this, ListActivity::class.java))
            }else{
                Toast.makeText(this, "Password or username is incorrect", Toast.LENGTH_SHORT).show()
            }
        }
        binding.registerMe.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }


    }
}