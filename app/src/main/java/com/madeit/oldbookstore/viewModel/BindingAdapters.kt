package com.madeit.oldbookstore.viewModel

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("android:text")
    fun setText(editText: EditText, text: String?) {
        if (editText.text.toString() != text) {
            editText.setText(text)
        }
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    fun getText(editText: EditText): String {
        return editText.text.toString()
    }

    @JvmStatic
    @BindingAdapter("android:textAttrChanged")
    fun setTextListener(editText: EditText, listener: InverseBindingListener?) {
        if (listener != null) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    listener.onChange()
                }
            })
        }
    }
}