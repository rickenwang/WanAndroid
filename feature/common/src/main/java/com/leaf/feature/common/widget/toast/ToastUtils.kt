package com.leaf.feature.common.widget.toast

import android.content.Context
import android.widget.Toast


/**
 *
 * Created by leafwang on 2023/2/3.
 */

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}