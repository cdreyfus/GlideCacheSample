package com.cdreyfus.glide.cache.sample.configuration

import com.bumptech.glide.load.Key
import java.security.MessageDigest

data class AndroidApiSignature(private val api: String) : Key {

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update(api.toByteArray())
    }
}