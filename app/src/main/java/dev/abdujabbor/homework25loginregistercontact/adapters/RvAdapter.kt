package dev.abdujabbor.homework25loginregistercontact.adapters

import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.abdujabbor.homework25loginregistercontact.databinding.MyRvItemBinding
import dev.abdujabbor.homework25loginregistercontact.models.User

class RvAdapter(val list:List<User>, val rvClick: RvClick): RecyclerView.Adapter<RvAdapter.Vh>(){

    inner class Vh(var itemRv: MyRvItemBinding): RecyclerView.ViewHolder(itemRv.root){
        fun onBind(user:User){
            itemRv.myName.text=user.name
            itemRv.myNumber.text=user.number
            itemRv.perssonImage.setImageBitmap(BitmapFactory.decodeFile(user.image))
            itemRv.card.setOnClickListener {
                rvClick.editClick(user)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(MyRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface RvClick{
        fun editClick(user: User)
    }
}