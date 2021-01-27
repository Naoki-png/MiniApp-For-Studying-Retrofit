package com.example.webapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.webapplication.R
import com.example.webapplication.model.News
import com.example.webapplication.repository.Repository
import com.example.webapplication.ui.HomeFragmentDirections
import javax.inject.Inject

class HomeAdapter @Inject constructor(
    private val fragment: Fragment
): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    private var newsList = emptyList<News>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val newsTitle = view.findViewById<TextView>(R.id.news_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.newsTitle.text = newsList[position].newsTitle
        holder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(newsList[position])
            findNavController(fragment).navigate(action)
        }
    }

    override fun getItemCount() = newsList.size

    fun setList(list: List<News>) {
        newsList = list
        notifyDataSetChanged()
    }
}