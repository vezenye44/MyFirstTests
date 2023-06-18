package com.example.myfirsttests

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

class EmailValidator : TextWatcher {

    internal var isValid = false

    override fun afterTextChanged(editableText: Editable) {
        isValid = isValidEmail(editableText)
    }

    override fun beforeTextChanged(
        s: CharSequence, start: Int, count: Int,
        after:
        Int,
    ) = Unit

    override fun onTextChanged(
        s: CharSequence, start: Int, before: Int,
        count:
        Int,
    ) = Unit

    companion object {
        /**
         * Паттерн для сравнения.
         */
        private val EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z\\d+._%\\-]{1,256}" +
                    "@" +
                    "[a-zA-Z\\d][a-zA-Z\\d\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z\\d][a-zA-Z\\d\\-]{1,3}" +
                    ")+"
        )

        fun isValidEmail(email: CharSequence?): Boolean {
            return email != null && EMAIL_PATTERN.matcher(email).matches()
        }
    }
}
