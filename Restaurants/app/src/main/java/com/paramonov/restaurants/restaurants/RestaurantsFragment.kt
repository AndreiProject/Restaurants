package com.paramonov.restaurants.restaurants

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.KeyEvent.*
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.paramonov.restaurants.common.extensions.*
import com.paramonov.restaurants.common.extensions.flow.observe
import com.paramonov.restaurants.common.extensions.ui.setItems
import com.paramonov.restaurants.common.fragments.BindingFragment
import com.paramonov.restaurants.databinding.FragmentRestaurantsBinding

class RestaurantsFragment : BindingFragment<FragmentRestaurantsBinding>(
    FragmentRestaurantsBinding::inflate
) {
    private val viewModel: RestaurantsViewModel by viewModels { getViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSearch()
        setupRecyclerView()
        setupOnErrorMessage()
        viewModel.loadOnLaunch()
    }

    private fun setupSearch() = with(binding) {
        search.setOnKeyListener { _, keyCode, event ->
            if (event.action == ACTION_DOWN && keyCode == KEYCODE_ENTER) {
                hideKeyboard()
                viewModel.updateRestaurants(search.text.toString())
                true
            }
            false
        }
    }

    private fun hideKeyboard() {
        val view: View? = requireActivity().currentFocus
        if (view != null) {
            val systemService = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE)
            val imm: InputMethodManager? = systemService as InputMethodManager?
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun setupRecyclerView() = with(binding) {
        restaurants.adapter = FastItemAdapter<RestaurantsItemAdapter>()
        restaurants.itemAnimator = null
        viewModel.restaurants.observe(viewLifecycleOwner) { setRestaurantsItems(it) }
    }

    private fun setRestaurantsItems(items: List<RestaurantsUiModel>) = with(binding) {
        val restaurantsItems = items.map { RestaurantsItemAdapter(it) }
        restaurants.setItems(restaurantsItems)
    }

    private fun setupOnErrorMessage() {
        viewModel.onError.observe(viewLifecycleOwner) { showMessage(it) }
    }
}