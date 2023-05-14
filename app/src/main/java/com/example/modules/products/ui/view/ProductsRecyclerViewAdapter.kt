package com.example.modules.products.ui.view

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.modules.R
import com.example.modules.databinding.ItemProductBinding
import com.example.modules.products.ui.ProductUiModel

class ProductsRecyclerViewAdapter(
    private val productClicked: (ProductUiModel) -> Unit,
) : ListAdapter<ProductUiModel, ProductsRecyclerViewAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )

        val viewHolder = ProductViewHolder(binding)

        binding.root.setOnClickListener {
            productClicked(getItem(viewHolder.bindingAdapterPosition))
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            root.text = root.context.getString(R.string.product_item_content, item.name)
        }
    }

    class ProductViewHolder(
        val binding: ItemProductBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    class ProductDiffCallback : DiffUtil.ItemCallback<ProductUiModel>() {
        override fun areItemsTheSame(oldItem: ProductUiModel, newItem: ProductUiModel): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ProductUiModel, newItem: ProductUiModel): Boolean =
            oldItem == newItem
    }
}
