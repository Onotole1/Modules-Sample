package com.example.modules.utils

import android.os.Build
import android.os.Bundle
import java.io.Serializable

inline fun <reified T : Serializable> Bundle.getSerializableCompat(key: String): T? =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getSerializable(key, T::class.java)
    } else {
        @Suppress("DEPRECATION")
        getSerializable(key) as? T
    }

inline fun <reified T : Serializable> Bundle.requireSerializable(key: String): T =
    requireNotNull(getSerializableCompat(key))
