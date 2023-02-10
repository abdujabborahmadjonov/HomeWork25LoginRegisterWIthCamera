package dev.abdujabbor.homework25loginregistercontact.dialogs

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dev.abdujabbor.homework25loginregistercontact.MyData
import dev.abdujabbor.homework25loginregistercontact.R
import dev.abdujabbor.homework25loginregistercontact.databinding.DialogBottomSheetBinding

class DialogBottomSheet : Fragment() {

val binding by lazy { DialogBottomSheetBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val user = MyData.user
        Toast.makeText(binding.root.context, user?.name + "salom", Toast.LENGTH_SHORT).show()
        binding.name.text = user?.name
        binding.number.text = user?.number
        binding.userImage.setImageBitmap(BitmapFactory.decodeFile(user?.image))
        return binding.root
    }
}