package com.karim.registrationunittest

import java.util.regex.Pattern
import androidx.core.util.PatternsCompat


object RegistrationUtil {

    private val existingUsers = listOf("karim-bahi", "and-dev")
    private val existingEmails = listOf("karim@gmail.com", "anddev@gmail.com")

    /**
     * the input is not valid if...
     * ...the email is empty
     * ...the email is not valid
     * ...the email is already token
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as the real password
     * ...the password not valid should be (more than 8 characters, including numbers, uppercase letter and symbols)
     */
    fun validateRegistrationInput(
        email: String,
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean {

        if (!isValidEmail(email ) || (email in existingEmails)) {
            return false
        }
        if (username in existingUsers ||username.isEmpty()) {
            return false
        }
        if (password != confirmedPassword) {
            return false
        }
        if (!isValidPassword(password)) {
            return false
        }
        return true
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return email.isNotEmpty() && return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: CharSequence): Boolean {
        val passwordPattern =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"
        val pattern = Pattern.compile(passwordPattern)
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }

}