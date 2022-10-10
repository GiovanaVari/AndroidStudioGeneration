package com.giovana.sqlitecomroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giovana.sqlitecomroom.data.Usuario
import com.giovana.sqlitecomroom.databinding.CardLayoutBinding
//Room video3 pt2{
//Implemetar o que falta
class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    //}

    //Room video3 pt3{
    //chama a lista de usuarios
    private var listUser = emptyList<Usuario>()
    //}

    //Room video3 pt1{
    //criando a viewholder
    class UserViewHolder (val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    //}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //Room video3 pt4{
        return UserViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
        //}

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        //Room video3 pt5{
        //criando a lista
        val user = listUser[position]

        holder.binding.textId.text = user.id.toString()
        holder.binding.textNome.text = user.nome
        holder.binding.textSobrenome.text = user.sobrenome
        holder.binding.textIdade.text = user.idade.toString()
        //}

    }

    override fun getItemCount(): Int {
        //Room video3 pt6{
        return listUser.size
    }

    fun setList(list: List<Usuario>){
        listUser = list
        //muda quando atualiza
        notifyDataSetChanged()
    }
    //}

}