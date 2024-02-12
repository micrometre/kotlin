package com.example.retrofitfileupload

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retrofitfileupload.ui.theme.RetrofitfileuploadTheme
import java.io.File

class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitfileuploadTheme {
                val viewModel = viewModel<FileViewModel>()
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Button(onClick = {
                        val file = File(cacheDir, "myImage.jpg")
                        file.createNewFile()
                        file.outputStream().use {
                            assets.open("image.jpg").copyTo(it)
                        }
                        viewModel.uploadImage(file)
                    }) {
                     Text(text = "Upload Image")
                    }
                }

            }
        }
    }
}
