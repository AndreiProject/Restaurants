package com.paramonov.restaurants.hits

import android.view.*
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.paramonov.restaurants.common.extensions.flow.observe
import com.paramonov.restaurants.common.extensions.*
import com.paramonov.restaurants.common.extensions.ui.setItems
import com.paramonov.restaurants.common.fragments.BindingFragment
import com.paramonov.restaurants.databinding.FragmentHitsBinding
import com.paramonov.restaurants.hits.network.HitsModel

class HitsFragment : BindingFragment<FragmentHitsBinding>(FragmentHitsBinding::inflate) {
    private val viewModel: HitsViewModel by viewModels { getViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupOnErrorMessage()
        viewModel.loadOnLaunch()
    }

    private fun setupRecyclerView() = with(binding) {
        hits.adapter = FastItemAdapter<HitsItemAdapter>()
        hits.itemAnimator = null
        viewModel.hits.observe(viewLifecycleOwner) { setHitsItems(it) }
    }

    private fun setHitsItems(items: List<HitsModel>) = with(binding) {
        val hitsItems = items.map { HitsItemAdapter(it) }
        hits.setItems(hitsItems)
    }

    private fun setupOnErrorMessage() {
        viewModel.onError.observe(viewLifecycleOwner) { showMessage(it) }
    }
}