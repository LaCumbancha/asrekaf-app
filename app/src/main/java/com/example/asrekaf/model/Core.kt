package com.example.asrekaf.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Core {

    private var apiKey: String? = null
    private const val tokenTimePattern = "YYYYMMddHHmm"

    fun setKey(key: String) { apiKey = key }

    @RequiresApi(Build.VERSION_CODES.O)
    fun generateToken(code: String): String {
        val dateTime = LocalDateTime.now()
        val key = dateTime.format(DateTimeFormatter.ofPattern(tokenTimePattern))
        return Hasher.hash(code + key, HashType.MD5).toUpperCase().substring(0, 8)
    }

}