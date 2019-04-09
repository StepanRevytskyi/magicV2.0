package com.arondillqs5328.magicv20.presentation.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arondillqs5328.magicv20.strategy.AddToEndSingleByTagStateStrategy

const val TAG_PROGRESS_BAR: String = "tagProgressBar"
const val TAG_FOOTER: String = "tagFooter"

interface BasicView : MvpView {

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy::class, tag = TAG_PROGRESS_BAR)
    fun showProgressBar()

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy::class, tag = TAG_PROGRESS_BAR)
    fun hideProgressBar()
}