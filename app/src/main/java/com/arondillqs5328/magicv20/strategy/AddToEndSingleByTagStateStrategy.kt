package com.arondillqs5328.magicv20.strategy

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.ViewCommand
import com.arellomobile.mvp.viewstate.strategy.StateStrategy

class AddToEndSingleByTagStateStrategy : StateStrategy {

    override fun <View : MvpView?> beforeApply(currentState: MutableList<ViewCommand<View>>?, incomingCommand: ViewCommand<View>?) {
        val iterator = currentState?.iterator()

        while (iterator!!.hasNext()) {
            val entry = iterator.next()

            if (entry.tag == incomingCommand!!.tag) {
                iterator.remove()
                break
            }
        }
        currentState.add(incomingCommand!!)
    }

    override fun <View : MvpView?> afterApply(currentState: MutableList<ViewCommand<View>>?, incomingCommand: ViewCommand<View>?) {

    }
}