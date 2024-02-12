package com.example.retrofitfileupload

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.File

class FileViewModel(
    private val repository: FileRepsitory = FileRepsitory()
): ViewModel(){
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun uploadImage(file: File) {
        viewModelScope.launch {
            repository.uploadImage(file)

        }
    }
}