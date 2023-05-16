package com.example.credits.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.credits.ui.CreditUiModel
import com.example.credits.ui.presenter.CreditsPresenter
import com.example.credits.databinding.FragmentCreditsListBinding
import com.example.credits.core.domain.OfferType
import com.example.modules.utils.requireSerializable
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.get
import org.koin.core.parameter.parametersOf

internal class CreditsFragment : MvpAppCompatFragment(), CreditsView {

    companion object {
        private const val ARG_OFFER_TYPE = "offer-type"

        fun newInstance(offerType: OfferType) =
            CreditsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_OFFER_TYPE, offerType)
                }
            }
    }

    private var adapter: CreditsRecyclerViewAdapter? = null

    init {
        moxyPresenter {
            val offerType: OfferType = requireArguments().requireSerializable(ARG_OFFER_TYPE)

            get<CreditsPresenter> {
                parametersOf(offerType)
            }
        }
    }

    override fun showCredits(credits: List<CreditUiModel>) {
        adapter?.submitList(credits)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentCreditsListBinding.inflate(inflater, container, false)

        val recycler = binding.list

        recycler.adapter = CreditsRecyclerViewAdapter().also {
            adapter = it
        }

        recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
    }
}
