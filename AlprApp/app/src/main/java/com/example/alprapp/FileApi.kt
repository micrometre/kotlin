package com.example.alprapp
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
        val instance: FileApi by lazy {
            Retrofit.Builder()
                .baseUrl("http://0.0.0.0:8080/file")
                .build()
                .create(FileApi::class.java)

        }
    }
}