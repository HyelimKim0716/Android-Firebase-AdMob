package com.sample.advertisement.adsample

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

import com.google.android.gms.ads.MobileAds
import com.crashlytics.android.Crashlytics
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import io.fabric.sdk.android.Fabric
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity() {

    lateinit var adView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, resources.getString(R.string.banner_ad_unit_id))

        verticalLayout {
            button("Crash Force") {

                setOnClickListener {
                    throw RuntimeException("This is a crash")
                }
            }

            adView = include<AdView>(R.layout.ad_view).lparams(matchParent, dip(100))
        }

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }
}
