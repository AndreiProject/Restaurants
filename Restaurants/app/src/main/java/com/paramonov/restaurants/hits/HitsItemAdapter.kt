package com.paramonov.restaurants.hits

import android.view.*
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.paramonov.restaurants.R
import com.paramonov.restaurants.common.extensions.ui.*
import com.paramonov.restaurants.databinding.FragmentHitsItemBinding
import com.paramonov.restaurants.hits.network.HitsModel

class HitsItemAdapter(
    private val hits: HitsModel,
) : AbstractBindingItem<FragmentHitsItemBinding>() {
    override var identifier: Long = hits.hashCode().toLong()
    override val type = R.id.hits_item_id

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?,
    ) = FragmentHitsItemBinding.inflate(inflater, parent, false)

    override fun bindView(
        binding: FragmentHitsItemBinding,
        payloads: List<Any>,
    ) = with(binding) {
        productName.text = hits.productName
        description.text = hits.productDescription
        image.clipToOutline = true
        image.loadByUrl(hits.productImage, R.drawable.ic_stub)
    }

    override fun unbindView(binding: FragmentHitsItemBinding) = with(binding) {
        productName.text = null
        description.text = null
        image.clipToOutline = false
        image.setDrawableFromResource(R.drawable.ic_stub)
    }
}