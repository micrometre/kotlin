package com.example.retrofitfileupload

import okhttp3.MultipartBody
import retrofit2.Retrofit
import retrofit2.http.Multipart
import retrofit2.http.Part

interface FileApi {
    @Multipart
    suspend fun uplaodImage(
        @Part image: MultipartBody.Part
    )
    companion object {
        val instance by lazy {
            Retrofit.Builder()
                .baseUrl("http://35.246.54.118:5000/upload")
                .build()
                .create(FileApi::class.java)

        }
    }
}