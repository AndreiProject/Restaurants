package com.paramonov.restaurants.reviews

import android.view.*
import com.paramonov.restaurants.R
import com.paramonov.restaurants.databinding.*
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.paramonov.restaurants.common.extensions.ui.setDrawableFromResource

class ReviewsItemAdapter(
    private val reviews: ReviewsUiModel,
) : AbstractBindingItem<FragmentReviewsItemBinding>() {
    override var identifier: Long = reviews.hashCode().toLong()
    override val type = R.id.reviews_item_id

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?,
    ) = FragmentReviewsItemBinding.inflate(inflater, parent, false)

    override fun bindView(
        binding: FragmentReviewsItemBinding,
        payloads: List<Any>,
    ) = with(binding) {
        val drawable = if (reviews.isPositive) R.drawable.ic_like else R.drawable.ic_dislike
        isPositive.setDrawableFromResource(drawable)
        title.text = reviews.title
        message.text = reviews.message
        data.text = reviews.data
    }

    override fun unbindView(binding: FragmentReviewsItemBinding) = with(binding) {
        isPositive.setDrawableFromResource(R.drawable.ic_like)
        title.text = null
        message.text = null
        data.text = null
    }
}