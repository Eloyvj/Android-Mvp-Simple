package com.example.mysimplemvp

class LoginPresenter(var loginView: LoginView?, val loginInteractor: LoginInteractor) :
    LoginInteractor.OnLoginFinishedListener {
    override fun onUsernameError() {
        loginView?.apply {
            setUsernameError()
            hideProgress()
        }
    }

    override fun onPasswordError() {
        loginView?.apply {
            setPasswordError()
            hideProgress()
        }
    }

    override fun onSuccess() {
        loginView?.apply {
            navigateToHome()
        }
    }

    fun onDestroy() {
        loginView = null
    }

    fun validateCredentials(username: String, password: String) {
        loginView?.showProgress()
        loginInteractor.login(username, password, this)
    }
}