package dev.abdujabbor.homework25loginregistercontact.ui

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import dev.abdujabbor.homework25loginregistercontact.BuildConfig
import dev.abdujabbor.homework25loginregistercontact.R
import dev.abdujabbor.homework25loginregistercontact.databinding.ActivityMainBinding
import dev.abdujabbor.homework25loginregistercontact.databinding.ActivityRegisterBinding
import dev.abdujabbor.homework25loginregistercontact.db.MyDbHelper
import dev.abdujabbor.homework25loginregistercontact.models.User
import dev.abdujabbor.homework25loginregistercontact.models.Usercha
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RegisterActivity : AppCompatActivity() {
    lateinit var dbHelper: MyDbHelper
    lateinit var photoUri: Uri
    lateinit var picturepath: String
    lateinit var currentImagePath: String
    lateinit var list: ArrayList<User>
    val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dbHelper = MyDbHelper(this)

        binding.image.setOnClickListener {
            showPictureDialog()
        }

        binding.register.setOnClickListener {
            val user = User(
                binding.userName.text.toString(),
                binding.password.text.toString(),
                binding.number.text.toString(),
                picturepath
            )
            val usercha = Usercha(
                binding.userName.text.toString(),
                binding.password.text.toString(),
            )

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            dbHelper.addUsercha(usercha)
            dbHelper.addUser(user)
        }

    }

    private val SELECT_PICTURE = 1

    fun showPictureDialog() {
        val pictureDialog = AlertDialog.Builder(this)
        pictureDialog.setTitle("Select Action")
        val pictureDialogItems = arrayOf("Select photo from gallery", "Capture photo from camera")
        pictureDialog.setItems(
            pictureDialogItems
        ) { _, which ->
            when (which) {
                0 -> choosePhotoFromGallary()
                1 -> takePhotoFromCamera()
            }
        }
        pictureDialog.show()
    }

    fun choosePhotoFromGallary() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, SELECT_PICTURE)
    }

    private fun takePhotoFromCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, 100)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK && null != data) {
            val selectedImage = data.data
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
            val cursor = contentResolver.query(selectedImage!!, filePathColumn, null, null, null)
            cursor!!.moveToFirst()
            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            picturepath = cursor.getString(columnIndex)
            cursor.close()
            binding.image.setImageBitmap(BitmapFactory.decodeFile(picturepath))
            Toast.makeText(this, picturepath, Toast.LENGTH_SHORT).show()
        }
    }
}