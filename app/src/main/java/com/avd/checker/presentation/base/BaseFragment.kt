package com.avd.kotlin_rss.presentation.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Aleksey Dementyev on 10.10.2017.
 */

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?)
            = inflater?.inflate(getLayoutId(), container, false)

    abstract fun getLayoutId() : Int
}