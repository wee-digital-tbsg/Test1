package wee.digital.example.util

import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.google.gson.Gson
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import wee.digital.example.App

private val convertFactory: Gson by lazy { Gson() }

@GlideModule
class MyGlideApp : AppGlideModule()

fun ImageView.load(url: String?) {
    GlideApp
        .with(context)
        .load(url)
        .override(width, height)
        .into(this)
}

fun toast(message: String?) {
    message ?: return
    if (Looper.myLooper() == Looper.getMainLooper()) {
        Toast.makeText(App.instance, message, Toast.LENGTH_SHORT).show()
    } else {
        Handler(Looper.getMainLooper()).post { Toast.makeText(App.instance, message, Toast.LENGTH_SHORT).show() }
    }
}

interface SimpleObserver<T> : SingleObserver<T> {
    override fun onSuccess(t: T) {

    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onError(e: Throwable) {
        toast(e.message)
    }
}