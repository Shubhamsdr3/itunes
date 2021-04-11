package com.example.itunes.data

import com.example.itunes.BR
import com.example.itunes.R
import com.example.itunes.base.IRecyclerItemViewModel
import com.example.itunes.callbacks.OnAdapterItemClickListener

class VideoRecyclerViewItem(private val ituneDto: ItuneDto, private val callback: OnAdapterItemClickListener): IRecyclerItemViewModel {

    override fun getLayoutId(): Int {
        return R.layout.video_item
    }

    override fun getBindingPairs(): List<Pair<Int, Any>> {
        return listOf(Pair(BR.item, ituneDto), Pair(BR.callback, callback))
    }
}