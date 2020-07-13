package com.valid.ui.component

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.valid.bussinesLogic.errors.ErrorManager
import com.valid.data.Resource
import com.valid.data.errors.ErrorMapper
import com.valid.ui.base.BaseViewModel
import com.valid.util.Event
import javax.inject.Inject

class DetailsViewModel @Inject
constructor() : BaseViewModel() {

    override val errorManager: ErrorManager
        get() = ErrorManager(ErrorMapper())




}
