package com.paramonov.restaurants.common.extensions.ui

import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import java.lang.NullPointerException

private const val errorMessage = "В RecyclerView установлен адаптер %s, который " +
    "не может быть приведён к FastItemAdapter."

fun <T : GenericItem> RecyclerView.getFastAdapter(): FastItemAdapter<T> {
    if (adapter == null) throw NullPointerException("Адаптер не установлен. Установите адаптер перед его использованием.")
    return adapter as? FastItemAdapter<T>
        ?: throw NullPointerException(errorMessage.format(adapter!!::class.java.name))
}

fun <T : GenericItem> RecyclerView.setItems(items: List<T>) = getFastAdapter<T>().setItems(items)