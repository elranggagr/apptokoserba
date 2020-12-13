package com.example.apptokoserba.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.apptokoserba.data.model.ActionState
import com.example.apptokoserba.data.model.AuthUser
import com.example.apptokoserba.util.getObject
import com.example.apptokoserba.util.putObject

class AuthPref(val context: Context) {
        private val sp: SharedPreferences by lazy {
            context.getSharedPreferences(AuthPref::class.java.name, Context.MODE_PRIVATE)
        }

        private companion object {
            const val AUTH_USER = "auth_user"
            const val IS_LOGIN = "is_login"
        }

      var authUser: AuthUser?
            get() = sp.getObject(AUTH_USER)
            set(value) = sp.edit().putObject(AUTH_USER, value).apply()

        var islogin: Boolean
        get() = sp.getBoolean(IS_LOGIN, false)
        set(value) = sp.edit().putBoolean(IS_LOGIN, value).apply()

    suspend fun login(email: String, password: String): ActionState<AuthUser> {
        val user = authUser
        return if (user == null) {
            ActionState(message = "Kamu Belum Terdaftar", isSuccess = false)
        } else if (email.isBlank() || password.isBlank()) {
            ActionState(message = "Email dan passwoerd tidak boleh kosong", isSuccess = false)
        } else if (user.email == email && user.password == password) {
            islogin = true
            ActionState(authUser, message = "Anda berhasil Login")
        } else {

            ActionState(message = "Email atau Password salah", isSuccess = false)
        }
    }

    suspend fun register(user: AuthUser): ActionState<AuthUser> {
        return if (user.email.isBlank() || user.password.isBlank()) {
            ActionState(
                    message = "Email dan password tidak  boleh kosong",
                    isSuccess = false
            )
        } else {
            authUser = user
            ActionState(user, message = "Anda berhasil daftar")
        }
    }
    suspend fun logout(): ActionState<Boolean>{
        islogin = false
        return ActionState(true, message = "anda berhasil logout")
    }
}
