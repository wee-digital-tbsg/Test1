package wee.digital.example.network

import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val apiService: ApiService by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
    Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/wee-test/Assets/master/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()
        .create(ApiService::class.java)
}

interface ApiService {

    //@GET("image_list")
    //fun imageList(): Single<List<ImageItem>>

    //@GET("user_list")
    //fun userList(): Single<List<UserItem>>

    //@GET("image_list")
    //suspend fun imageList(): Single<List<ImageItem>>

    //@GET("user_list")
    //suspend fun userList(): Single<List<UserItem>>
}

