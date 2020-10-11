package com.cdreyfus.glide.cache.sample.configuration

import android.util.Base64
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.data.DataFetcher
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import java.nio.ByteBuffer

class JsonAndroidLogoDataFetcher(private val model: JsonAndroidLogo) : DataFetcher<ByteBuffer> {

    override fun loadData(
        priority: Priority,
        callback: DataFetcher.DataCallback<in ByteBuffer>
    ) {
        val data: ByteArray = Base64.decode(model.image64, Base64.DEFAULT)
        val byteBuffer = ByteBuffer.wrap(data)
        callback.onDataReady(byteBuffer)
    }

    override fun cleanup() {}
    override fun cancel() {}

    override fun getDataClass(): Class<ByteBuffer> {
        return ByteBuffer::class.java
    }

    override fun getDataSource(): DataSource {
        return DataSource.REMOTE
    }
}

class JsonAndroidLogoModelLoader : ModelLoader<JsonAndroidLogo, ByteBuffer> {

    override fun buildLoadData(
        model: JsonAndroidLogo,
        width: Int,
        height: Int,
        options: Options
    ): ModelLoader.LoadData<ByteBuffer> {
        return ModelLoader.LoadData(AndroidApiSignature(model.apiVersion), JsonAndroidLogoDataFetcher(model))
    }

    override fun handles(model: JsonAndroidLogo): Boolean {
        return !model.image64.isBlank()
    }
}

class JsonAndroidVersionModelLoaderFactory : ModelLoaderFactory<JsonAndroidLogo, ByteBuffer> {
    override fun build(unused: MultiModelLoaderFactory): ModelLoader<JsonAndroidLogo, ByteBuffer> {
        return JsonAndroidLogoModelLoader()
    }

    override fun teardown() { // Do nothing.
    }
}