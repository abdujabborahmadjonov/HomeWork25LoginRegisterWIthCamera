package dev.abdujabbor.homework25loginregistercontact.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.abdujabbor.homework25loginregistercontact.databinding.ActivityLoginBinding
import dev.abdujabbor.homework25loginregistercontact.db.MyDbHelper
import dev.abdujabbor.homework25loginregistercontact.models.User

class LoginActivity : AppCompatActivity() {
    lateinit var dbHelper: MyDbHelper
    lateinit var list: ArrayList<User>
    val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dbHelper = MyDbHelper(this)
        list = dbHelper.getAllUsers()

        binding.login.setOnClickListener {
            var has = false
            for (user in list) {
                if (user.name == binding.textUsername.text.toString() && user.password == binding.textPassword.text.toString()) {
                    startActivity(Intent(this, ListActivity::class.java))
                    has = true
                    break
                }

            }
            if (!has) {
                Toast.makeText(this, "Name of Number is incorrect", Toast.LENGTH_SHORT).show()
            }

        }
        binding.registerMe.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }


    }
}