package com.example.itunes.data

import android.util.Log
import com.example.itunes.base.IBaseRecyclerViewAdapter
import com.example.itunes.base.IRecyclerItemViewModel

class VideoListAdapter: IBaseRecyclerViewAdapter<IRecyclerItemViewModel>(mutableListOf()) {

    override fun registerItemClick(holder: BaseBindingViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            Log.d("VideoListAdapter","The clicked item is: $position")
        }
    }
}
