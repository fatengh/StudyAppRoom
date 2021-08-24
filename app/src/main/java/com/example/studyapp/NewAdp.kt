package com.example.studyapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studyapp.databinding.ItemRowBinding

class NewAdp(private val activity: Activity, private val lessons: ArrayList<Lessons>) :
    RecyclerView.Adapter<NewAdp.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            tvLesson.text = "id: ${lessons[position].id} Title: ${lessons[position].title}"
            tvContent.text = lessons[position].description
            cvCard.setOnClickListener {
                CustomAlertDialog(
                    activity,
                    lessons[position].details
                )
            }
        }
    }

    override fun getItemCount() = lessons.size
}