package com.example.itunes.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.itunes.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class IBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    fun startFragment(fragment: Fragment, addToBackStack: Boolean) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fragmentContainer, fragment, fragment.javaClass.simpleName)
        if (addToBackStack) {
            ft.addToBackStack(fragment.javaClass.simpleName)
        }
        ft.commit()
    }
}