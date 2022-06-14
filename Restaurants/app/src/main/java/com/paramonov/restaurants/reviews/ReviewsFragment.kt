package com.paramonov.restaurants.reviews

import android.view.*
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.paramonov.restaurants.common.extensions.flow.observe
import com.paramonov.restaurants.common.extensions.*
import com.paramonov.restaurants.common.extensions.ui.setItems
import com.paramonov.restaurants.common.fragments.BindingFragment
import com.paramonov.restaurants.databinding.FragmentReviewsBinding
import com.paramonov.restaurants.restaurants.RestaurantsItemAdapter

class ReviewsFragment : BindingFragment<FragmentReviewsBinding>(FragmentReviewsBinding::inflate) {
    private val viewModel: ReviewsViewModel by viewModels { getViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupOnErrorMessage()
        viewModel.loadOnLaunch()
    }

    private fun setupRecyclerView() = with(binding) {
        reviews.adapter = FastItemAdapter<RestaurantsItemAdapter>()
        reviews.itemAnimator = null
        viewModel.reviews.observe(viewLifecycleOwner) { setRestaurantsItems(it) }
    }

    private fun setRestaurantsItems(items: List<ReviewsUiModel>) = with(binding) {
        val reviewsItems = items.map { ReviewsItemAdapter(it) }
        reviews.setItems(reviewsItems)
    }

    private fun setupOnErrorMessage() {
        viewModel.onError.observe(viewLifecycleOwner) { showMessage(it) }
    }
}