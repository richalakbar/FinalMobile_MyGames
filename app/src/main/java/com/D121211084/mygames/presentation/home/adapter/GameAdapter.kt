package com.D121211084.mygames.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.D121211084.mygames.data.source.remote.model.GamesResponse
import com.D121211084.mygames.databinding.ItemGameBinding
import com.D121211084.mygames.utils.ConverterDate
import com.D121211084.mygames.utils.convertDateTo
import com.D121211084.mygames.utils.loadImage

class GameAdapter(private val onItemClicked: (GamesResponse.Game) -> Unit) : ListAdapter<GamesResponse.Game, GameAdapter.ViewHolder>(
    DIFF_CALLBACK
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: GamesResponse.Game) {
            with(binding) {
                ivGame.loadImage(data.backgroundImage.orEmpty())
                tvGameTitle.text = data.name
                tvReleaseDate.text = data.released?.convertDateTo(ConverterDate.FULL_DATE)
                tvGameRate.text = data.rating.toString()
                root.setOnClickListener {
                    onItemClicked(data)
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GamesResponse.Game>() {
            override fun areItemsTheSame(oldItem: GamesResponse.Game, newItem: GamesResponse.Game): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: GamesResponse.Game, newItem: GamesResponse.Game): Boolean {
                return oldItem == newItem
            }
        }
    }

}