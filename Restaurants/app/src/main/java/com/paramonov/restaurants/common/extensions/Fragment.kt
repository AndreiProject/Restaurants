package com.paramonov.restaurants.common.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.paramonov.restaurants.common.appComponent

fun Fragment.showMessage(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Fragment.getViewModelFactory() = requireActivity().appComponent.factory