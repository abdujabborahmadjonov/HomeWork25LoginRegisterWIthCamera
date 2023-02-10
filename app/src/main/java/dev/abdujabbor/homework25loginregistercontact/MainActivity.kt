package dev.abdujabbor.homework25loginregistercontact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.FileProvider
import dev.abdujabbor.homework25loginregistercontact.databinding.ActivityMainBinding
import dev.abdujabbor.homework25loginregistercontact.ui.LoginActivity
import dev.abdujabbor.homework25loginregistercontact.ui.RegisterActivity

class MainActivity : AppCompatActivity() {
    lateinit var frombottom: Animation
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_NO_TITLE)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)


        binding.loginbtn.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.registerbtn.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.bgApp.animate().translationY(-1200F).setDuration(3000).setStartDelay(300)
        binding.loginbtn.animate().alpha(1F).setDuration(2000).setStartDelay(300)
        binding.cloverimg.animate().alpha(0F).setDuration(3000).setStartDelay(600)
        binding.splashtext.animate().translationY(140f).alpha(0f).setDuration(1800).setStartDelay(300)
        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom)
        binding.menus.startAnimation(frombottom)

        binding.hometxt.startAnimation(frombottom)
    }
}