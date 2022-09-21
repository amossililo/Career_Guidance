package com.career.guidance.utils.extensions

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import com.career.guidance.R


fun EditText.textToString(): String = this.text.toString()

fun EditText.checkIsEmpty(): Boolean = text == null || "" == textToString() || text.toString().equals("null", ignoreCase = true)

fun EditText.isValidEmail(): Boolean = !TextUtils.isEmpty(text) && Patterns.EMAIL_ADDRESS.matcher(text).matches()

fun EditText.isValidPhoneNumber(): Boolean = text.matches("^(((\\+?\\(91\\))|0|((00|\\+)?91))-?)?[7-9]\\d{9}$".toRegex())

fun EditText.showError(error: String) {
    this.error = error
    this.showSoftKeyboard()
}

fun EditText.validPassword(): Boolean = text.length < 6
