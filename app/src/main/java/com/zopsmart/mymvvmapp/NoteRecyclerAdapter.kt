package com.zopsmart.mvvmfirstapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.zopsmart.mvvmfirstapp.ViewModel.MainViewModel
//import com.zopsmart.mvvmfirstapp.databinding.ItemBinding
import com.zopsmart.mvvmfirstapp.model.Blog
import com.zopsmart.mymvvmapp.databinding.ItemBinding

class NoteRecyclerAdapter (val viewModel: MainViewModel, val arrayList: ArrayList<Blog>, val context: Context): RecyclerView.Adapter<NoteRecyclerAdapter.NotesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): NoteRecyclerAdapter.NotesViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val inflater = ItemBinding.inflate(layoutInflater, parent, false)
        return NotesViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: NoteRecyclerAdapter.NotesViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
            Toast.makeText(context,"List is empty", Toast.LENGTH_LONG).show()
        }else{

        }
        return arrayList.size
    }


    inner class NotesViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(blog: Blog){
            binding.title.text = blog.title
            binding.delete.setOnClickListener {
                viewModel.remove(blog)
                notifyItemRemoved(arrayList.indexOf(blog))
            }
        }

    }

}

