package com.example.architectureexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.architectureexample.ui.theme.ArchitectureExampleTheme

class MainActivity : ComponentActivity() {
    private val vieModel by viewModels<SampleVieModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchitectureExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = vieModel.backGroudColour
                ) {
                    Button(onClick = {
                        vieModel.changeBackGroundColour()
                    }) {
                    Text(text = "Chang Colour")
                    }
                }
            }
        }
    }
}

