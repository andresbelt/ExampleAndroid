package com.valid.bussinesLogic.errors

import com.valid.data.errors.ErrorEnum

interface ErrorFactory {
    fun getError(errorCode: Int): ErrorEnum
}