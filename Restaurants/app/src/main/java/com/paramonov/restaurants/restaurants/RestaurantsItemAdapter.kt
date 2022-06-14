package com.paramonov.restaurants.restaurants

import android.view.*
import com.paramonov.restaurants.R
import com.paramonov.restaurants.common.extensions.ui.*
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.paramonov.restaurants.databinding.FragmentRestaurantsItemBinding

class RestaurantsItemAdapter(
    private val restaurants: RestaurantsUiModel,
) : AbstractBindingItem<FragmentRestaurantsItemBinding>() {
    override var identifier: Long = restaurants.hashCode().toLong()
    override val type = R.id.restaurants_item_id

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?,
    ) = FragmentRestaurantsItemBinding.inflate(inflater, parent, false)

    override fun bindView(
        binding: FragmentRestaurantsItemBinding,
        payloads: List<Any>,
    ) = with(binding) {
        name.text = restaurants.name
        specializations.text = restaurants.specializations
        positiveReviews.text = restaurants.positiveReviews
        logo.loadByUrl(restaurants.logo, R.drawable.ic_stub)
    }

    override fun unbindView(binding: FragmentRestaurantsItemBinding) = with(binding) {
        name.text = null
        specializations.text = null
        positiveReviews.text = null
        logo.setDrawableFromResource(R.drawable.ic_stub)
    }
}