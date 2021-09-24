package com.karim.registrationunittest

import org.junit.Assert.*
import org.junit.Test

class RegistrationUtilTest{

    @Test
    fun `empty email returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "karim",
            "ABcd123!",
            "ABcd123!"
        )
        assertFalse(result)
    }

    @Test
    fun `not valid email returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "karim.com",
            "karim",
            "ABcd123!",
            "ABcd123!"
        )
        assertFalse(result)
    }

    @Test
    fun `email already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "karim@gmail.com",
            "karim",
            "ABcd123!",
            "ABcd123!"
        )
        assertFalse(result)
    }

    @Test
    fun `valid email returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "karimbahi@gmail.com",
            "karim",
            "ABcd123!",
            "ABcd123!"
        )
        assertTrue(result)
    }

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "karimbahi@gmail.com",
            "",
            "ABcd123!",
            "ABcd123!"
        )
        assertFalse(result)
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "karimbahi@gmail.com",
            "karim-bahi",
            "ABcd123!",
            "ABcd123!"
        )
        assertFalse(result)
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "karimbahi@gmail.com",
            "karim",
            "ABcd123!",
            "ABcd123!"
        )
        assertTrue(result)
    }

    @Test
    fun `incorrectly confirmed password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "karimbahi@gmail.com",
            "karim",
            "ABcd123!",
            "abcd"
        )
        assertFalse(result)
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "karimbahi@gmail.com",
            "karim",
            "",
            ""
        )
        assertFalse(result)
    }

    @Test
    fun `not validate password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "karimbahi@gmail.com",
            "karim",
            "abcdefg5",
            "abcdefg5"
        )
        assertFalse(result)
    }

    @Test
    fun `validate password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "karimbahi@gmail.com",
            "karim",
            "ABcd123!",
            "ABcd123!"
        )
        assertTrue(result)
    }
}