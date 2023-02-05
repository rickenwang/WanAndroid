package com.leaf.feature.login.ui

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.ViewModelProvider
import com.leaf.feature.common.widget.activity.BaseActivity
import com.leaf.feature.common.widget.toast.showToast
import com.leaf.feature.login.R
import com.therouter.TheRouter
import com.therouter.router.Navigator
import com.therouter.router.Route
import com.therouter.router.interceptor.NavigationCallback
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


/**
 *
 * Created by leafwang on 2023/2/2.
 */
@Route(path = "http://wanandroid.com/login")
class LoginActivity: BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            onClickLogin()
        }

        bindLoginUIState()
    }

    private fun bindLoginUIState() {
        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        lifecycleScope.launch {
            viewModel.mLoginUIStateFlow.collect {
                when (it) {
                    LoginUIState.Loading -> {}
                    LoginUIState.Failed -> {
                        showToast(this@LoginActivity, "登录失败")
                    }
                    is LoginUIState.Success -> {
                        loginSuccess()
                    }
                    else -> {}
                }
            }
        }

    }

    private fun onClickLogin() {

        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val name = etUserName.text.toString()
        val password = etPassword.text.toString()

        if (name.isEmpty() || password.isEmpty()) {
            showToast(this, "请先输入信息")
            return
        }

        lifecycleScope.launch {
            viewModel.login(name, password)
        }
    }

    private fun loginSuccess() {

        // 1. 查看携带的信息，看是否指定了落地页，否则跳转到默认的落地页
        TheRouter.build("http://wanandroid.com/main")
            .navigation(this, object : NavigationCallback() {
                override fun onActivityCreated(navigator: Navigator, destActivity: Activity) {
                    super.onActivityCreated(navigator, destActivity)
                    this@LoginActivity.finish()
                }
            })
    }

}