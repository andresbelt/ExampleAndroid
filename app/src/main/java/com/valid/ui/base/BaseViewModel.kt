package com.valid.ui.base

import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {
    abstract val errorManager: com.valid.bussinesLogic.errors.ErrorManager
}
