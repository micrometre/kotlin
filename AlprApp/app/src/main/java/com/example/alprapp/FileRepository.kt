package com.example.alprapp

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.IOException

class FileRepository{
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun uploadImage(file: File):  Boolean {
        return try {
            FileApi.instance.uploadImage(
                image = MultipartBody.Part
                    .createFormData(
                        "image",
                        file.name,
                        file.asRequestBody()
                    )
            )
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        } catch (e: HttpException) {
            e.printStackTrace()
            false
        }
    }
}