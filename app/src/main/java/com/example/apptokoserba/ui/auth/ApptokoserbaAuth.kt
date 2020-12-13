package com.example.apptokoserba.ui.auth

import android.content.Context
import com.example.apptokoserba.data.model.ActionState
import com.example.apptokoserba.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

    object ApptokoserbaAuth {
        fun logout(context: Context,callback:((ActionState<Boolean>) -> Unit )? = null ){
            val repo = AuthRepository(context)
            CoroutineScope(Dispatchers.IO).launch {
                val resp = repo.logout()
                withContext(Dispatchers.Main) {
                    callback?.invoke(resp)
                }
            }
        }
    }