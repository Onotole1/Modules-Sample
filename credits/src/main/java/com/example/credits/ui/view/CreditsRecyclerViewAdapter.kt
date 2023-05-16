package com.example.credits.ui.view

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import com.example.credits.R
import com.example.credits.ui.CreditUiModel
import com.example.credits.databinding.ItemCreditBinding

internal class CreditsRecyclerViewAdapter :
    ListAdapter<CreditUiModel, CreditsRecyclerViewAdapter.CreditViewHolder>(CreditDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditViewHolder {

        return CreditViewHolder(
            ItemCreditBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: CreditViewHolder, position: Int) {
        val item = getItem(position)
        holder.idView.text = item.id.toString()
        holder.contentView.text =
            holder.itemView.context.getString(
                R.string.credit_item_content,
                item.name,
                item.rate.toPlainString(),
            )
    }

    class CreditViewHolder(
        binding: ItemCreditBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
    }

    class CreditDiffCallback : ItemCallback<CreditUiModel>() {
        override fun areItemsTheSame(oldItem: CreditUiModel, newItem: CreditUiModel): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CreditUiModel, newItem: CreditUiModel): Boolean =
            oldItem == newItem
    }
}
