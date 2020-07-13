package com.valid.bussinesLogic.errors

import com.valid.data.errors.ErrorEnum
import com.valid.data.errors.ErrorMapper
import javax.inject.Inject

class ErrorManager @Inject constructor(private val errorMapper: ErrorMapper) :
    ErrorFactory {
    override fun getError(errorCode: Int): ErrorEnum {
        return ErrorEnum(code = errorCode, description = errorMapper.errorsMap.getValue(errorCode))
    }

}