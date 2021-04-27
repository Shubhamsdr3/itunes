package com.example.itunes.util

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.startFragment(@IdRes containerResId: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        addToBackStack(fragment::class.java.simpleName)
        add(containerResId, fragment, fragment::class.java.simpleName)
        commit()
    }
}

fun Fragment.startFragment(@IdRes containerResId: Int, fragment: Fragment) {
    childFragmentManager.beginTransaction().apply {
        addToBackStack(fragment::class.java.simpleName)
        add(containerResId, fragment, fragment::class.java.simpleName)
        commit()
    }
}