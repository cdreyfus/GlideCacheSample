package com.cdreyfus.glide.cache.sample.splashscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cdreyfus.glide.cache.sample.GlideApp
import com.cdreyfus.glide.cache.sample.R
import com.cdreyfus.glide.cache.sample.configuration.JsonAndroidLogo
import com.cdreyfus.glide.cache.sample.main.MainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class SplashscreenActivity : AppCompatActivity(R.layout.activity_splashscreen) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val androidLogos: List<JsonAndroidLogo> = Gson().fromJson(
            getJsonDataFromAsset(this), object : TypeToken<List<JsonAndroidLogo?>?>() {}.type
        )

        androidLogos.forEach {
            GlideApp.with(this).load(it).preload()
        }.run {
            startActivity(Intent(this@SplashscreenActivity, MainActivity::class.java))
        }
    }

    private fun getJsonDataFromAsset(context: Context): String? {
        return try {
            val open = context.assets.open("android_versions.json")
            open.bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            null
        }
    }
}