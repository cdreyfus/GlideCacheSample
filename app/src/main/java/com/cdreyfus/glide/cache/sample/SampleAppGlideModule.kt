package com.cdreyfus.glide.cache.sample

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.cdreyfus.glide.cache.sample.configuration.AndroidLogo
import com.cdreyfus.glide.cache.sample.configuration.AndroidLogoModelLoaderFactory
import com.cdreyfus.glide.cache.sample.configuration.JsonAndroidLogo
import com.cdreyfus.glide.cache.sample.configuration.JsonAndroidVersionModelLoaderFactory
import java.io.InputStream
import java.nio.ByteBuffer

@GlideModule
class SampleAppGlideModule: AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)

        registry.prepend(
            JsonAndroidLogo::class.java,
            ByteBuffer::class.java,
            JsonAndroidVersionModelLoaderFactory()
        ).prepend(
            AndroidLogo::class.java,
            InputStream::class.java,
            AndroidLogoModelLoaderFactory()
        )
    }
}