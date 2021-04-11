package com.example.itunes.callbacks

import com.example.itunes.data.ItuneDto

interface OnAdapterItemClickListener {

    fun onItemClicked(itemsDto: ItuneDto)
}