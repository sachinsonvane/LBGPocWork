package com.ss.lloydsbankpoc.base.validators

interface FieldValidator<T> {


    fun validate(value: T):Boolean
}