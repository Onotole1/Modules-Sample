package com.example.products.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.products.databinding.FragmentProductsListBinding
import com.example.products.ui.ProductUiModel
import com.example.products.ui.presenter.ProductsPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.get

internal class ProductsFragment : MvpAppCompatFragment(), ProductsView {

    companion object {
        fun newInstance() = ProductsFragment()
    }

    private var adapter: ProductsRecyclerViewAdapter? = null
    private val presenter: ProductsPresenter by moxyPresenter { get() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentProductsListBinding.inflate(inflater, container, false)

        val recycler = binding.list

        recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        recycler.adapter = ProductsRecyclerViewAdapter {
            presenter.onOfferClicked(it.type)
        }.also {
            adapter = it
        }

        return binding.root
    }

    override fun showProducts(products: List<ProductUiModel>) {
        adapter?.submitList(products)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
    }
}
