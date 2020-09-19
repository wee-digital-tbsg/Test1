package wee.digital.example.util

import android.widget.ImageView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.google.gson.Gson

private val convertFactory: Gson by lazy { Gson() }

@GlideModule
class MyGlideApp : AppGlideModule()

fun ImageView.load(url: String?) {
    GlideApp
        .with(context)
        .load(url)
        .into(this)
}