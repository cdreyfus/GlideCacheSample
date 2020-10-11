package com.cdreyfus.glide.cache.sample.configuration

import com.bumptech.glide.load.Options
import com.bumptech.glide.load.data.HttpUrlFetcher
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import java.io.InputStream

class AndroidLogoModelLoader : ModelLoader<AndroidLogo, InputStream> {

    override fun buildLoadData(
        model: AndroidLogo,
        width: Int,
        height: Int,
        options: Options
    ): ModelLoader.LoadData<InputStream> {
        return ModelLoader.LoadData(
            AndroidApiSignature(model.apiVersion),
            HttpUrlFetcher(GlideUrl(model.url), 500)
        )
    }

    override fun handles(model: AndroidLogo): Boolean {
        return true
    }
}

class AndroidLogoModelLoaderFactory : ModelLoaderFactory<AndroidLogo, InputStream> {
    override fun build(unused: MultiModelLoaderFactory): ModelLoader<AndroidLogo, InputStream> {
        return AndroidLogoModelLoader()
    }

    override fun teardown() { // Do nothing.
    }
}
