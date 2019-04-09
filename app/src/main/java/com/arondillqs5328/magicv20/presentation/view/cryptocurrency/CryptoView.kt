package com.arondillqs5328.magicv20.presentation.view.cryptocurrency

import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arondillqs5328.magicv20.presentation.view.BasicView
import com.arondillqs5328.magicv20.presentation.view.TAG_FOOTER
import com.arondillqs5328.magicv20.strategy.AddToEndSingleByTagStateStrategy

interface CryptoView : BasicView {

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy::class, tag = TAG_FOOTER)
    fun showFooter(isLoading: Boolean)

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy::class, tag = TAG_FOOTER)
    fun hideFooter()
}