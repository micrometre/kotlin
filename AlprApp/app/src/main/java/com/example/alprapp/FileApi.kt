package com.example.alprapp
import android.media.Image
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface FileApi {
    @Multipart
    @POST("/api/v1/uploadimage")
    fun uploadImage(
        @Part image: MultipartBody.Part
    ): Call<ResponseBody>
}