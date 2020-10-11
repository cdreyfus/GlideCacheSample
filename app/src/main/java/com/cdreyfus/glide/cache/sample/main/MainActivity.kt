package com.cdreyfus.glide.cache.sample.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.cdreyfus.glide.cache.sample.configuration.AndroidLogo
import com.cdreyfus.glide.cache.sample.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gridLayout.layoutManager = GridLayoutManager(this, 3)
        gridLayout.adapter = AndroidVersionAdapter(androidVersionsList)
    }

    private companion object {

        val androidVersionsList = listOf(
            AndroidLogo(
                "1.5", "https://images.frandroid.com/wp-content/uploads/2019/08/android-cupcake.png"
            ),
            AndroidLogo(
                "1.6", "https://images.frandroid.com/wp-content/uploads/2019/08/android-donut.jpg"
            ),
            AndroidLogo(
                "2.0",
                "https://images.frandroid.com/wp-content/uploads/2019/08/android-eclair-1200x800.jpg"
            ),
            AndroidLogo(
                "2.2", "https://hipertextual.com/archivo/wp-content/uploads/2010/05/froyo1.png"
            ),
            AndroidLogo(
                "2.3",
                "https://images.frandroid.com/wp-content/uploads/2019/08/android-gingerbread-1200x800.jpg"
            ),
            AndroidLogo(
                "3.0",
                "https://cnet3.cbsistatic.com/img/5o5uIVDPi0ydP-iffipMqwRybBQ=/470x353/2011/01/28/236e020d-cbf2-11e2-9a4a-0291187b029a/honeycomb-logo.jpg"
            ),
            AndroidLogo(
                "4.0",
                "https://images.frandroid.com/wp-content/uploads/2011/09/Android-2.4-Ice-Cream-Sandwich.jpg"
            ),
            AndroidLogo(
                "4.1",
                "https://images.frandroid.com/wp-content/uploads/2019/08/android-jelly-bean.jpg"
            ),
            AndroidLogo("4.4", "https://pic.clubic.com/v1/images/1262503/raw"),
            AndroidLogo("5.0", "https://pic.clubic.com/v1/images/1188001/raw"),
            AndroidLogo(
                "6.0", "https://images.frandroid.com/wp-content/uploads/2015/08/marshmallow.jpg"
            ),
            AndroidLogo(
                "7.0", "https://images.frandroid.com/wp-content/uploads/2017/06/android-nougat.jpg"
            ),
            AndroidLogo(
                "8.0,",
                "https://www.sony.com/articleimage/servlet/servlet.FileDownload?file=0155F000007AvSLQA0"
            ),
            AndroidLogo(
                "9.0",
                "https://images.frandroid.com/wp-content/uploads/2019/08/android-pie-1200x800.jpg"
            ),
            AndroidLogo(
                "10",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRVBDrZECy_zYuuCHqZ2ue4er-cxWlt0TrDRw&usqp=CAU"
            )
        )
    }
}