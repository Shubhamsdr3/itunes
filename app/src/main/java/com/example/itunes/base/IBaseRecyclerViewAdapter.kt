package com.example.itunes.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class IBaseRecyclerViewAdapter<Item: IRecyclerItemViewModel>(var items: MutableList<Item>) : RecyclerView.Adapter<IBaseRecyclerViewAdapter.BaseBindingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false) as ViewDataBinding
        return BaseBindingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder, position: Int) {
        holder.bindData(items[position])
        registerItemClick(holder, position)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].getLayoutId()
    }

    fun addData(data: List<Item>) {
        this.items.addAll(data)
        notifyDataSetChanged()
    }

    fun addItem(item: Item) {
        this.items.add(item)
        notifyItemChanged(itemCount)
    }

    abstract fun registerItemClick(holder: BaseBindingViewHolder, position: Int)

    class BaseBindingViewHolder internal constructor(var binding: ViewDataBinding) :  RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: Any?) {
            (item as IRecyclerItemViewModel).let {
                for (pair in it.getBindingPairs()) {
                    binding.setVariable(pair.first, pair.second)
                }
            }
            binding.executePendingBindings()
        }
    }
}