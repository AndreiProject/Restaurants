package com.paramonov.restaurants.common.controlflow

class SingleLaunch {
    private var isNotLaunch = true

    operator fun invoke(action: () -> Unit) {
        if (isNotLaunch) {
            isNotLaunch = false
            action()
        }
    }
}