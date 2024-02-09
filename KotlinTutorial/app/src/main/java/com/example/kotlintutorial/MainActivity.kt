package com.example.kotlintutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestingMain() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    val total = greenNumbers.count() + redNumbers.count()
    Text(text = "testing $total")
}



@Composable
fun StringTemplates() {
    var discountPercentage: Int = 0
    var offer: String = ""
    val item = "Google Chromecast"
    discountPercentage = 20
    "Sale - Up to $discountPercentage% discount on $item! Hurry up!".also { offer = it }
    Text(text = offer,)
}
