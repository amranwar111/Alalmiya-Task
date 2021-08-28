package com.team.alalmiya.ui.weather.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.entities.weather.remote.response.ListItem
import com.team.alalmiya.databinding.ItemWeatherBinding
import javax.inject.Inject


class WeatherRecycleViewAdapter @Inject constructor(
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var items: MutableList<ListItem>
    private lateinit var binding: ItemWeatherBinding



    @SuppressLint("NotifyDataSetChanged")
     fun setData(items: MutableList<ListItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val viewHolder: RecyclerView.ViewHolder?

        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        viewHolder = MainViewHolder(binding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        val mainViewHolder = holder as MainViewHolder

        mainViewHolder.bindData(item)
        holder.bindData(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class MainViewHolder(private val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: ListItem) {
            binding.txtPressure.text=item.main?.pressure.toString()
            binding.txtRealFeel.text=item.main?.feelsLike.toString()
            binding.txtWind.text=item.wind?.speed.toString()

        }
    }
}