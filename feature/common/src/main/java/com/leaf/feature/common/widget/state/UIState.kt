package com.leaf.feature.common.widget.state


/**
 *
 * Created by leafwang on 2023/2/2.
 */
sealed interface UIState<out T> {

    object Loading : UIState<Nothing>

    data class Success<out T>(val t: T): UIState<T>
}