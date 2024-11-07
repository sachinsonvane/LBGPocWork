package com.ss.lloydsbankpoc.base.validators

import com.ss.lloydsbankpoc.base.validators.FieldValidator

// Password validation class
class PasswordValidator : FieldValidator<String> {
    override fun validate(value: String): Boolean {
        return value.length >= 6
    }
}