package com.example.apiexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.apiexample.api.UserApi
import com.example.apiexample.ui.theme.ApiExampleTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApiExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

data class ProfileModel(
    var name: String,
)

data class UserModel(
    var profile: ProfileModel
)

@Composable
fun MainScreen() {
   Scaffold(
       content = {
          Column(
              modifier = Modifier.fillMaxWidth(),
              verticalArrangement = Arrangement.Center,
              horizontalAlignment = Alignment.CenterHorizontally
          ) {
              val id = remember {
                  mutableStateOf(TextFieldValue())
              }
              val profile = remember {
                  mutableStateOf(ProfileModel(
                      name = ""
                  ))
              }
              TextField(
                  label = { Text(text = "User ID")},
                  value = id.value,
                  onValueChange = { id.value = it }
              )


              Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                  Button(
                      onClick = {
                          val data = sendRequest(
                              id = id.value.text,
                              profileState = profile
                          )

                          Log.d("Main Activity", profile.toString())
                      }
                  ) {
                      Text(text = "Get Data")
                  }
              }
          }
       }
   )
}

fun sendRequest(
    id: String,
    profileState: MutableState<ProfileModel>
) {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.122:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(UserApi::class.java)

    val call: Call<UserModel?>? = api.getUserById(id)

    call!!.enqueue(object: Callback<UserModel?> {
        override fun onResponse(call: Call<UserModel?>, response: Response<UserModel?>) {
            if(response.isSuccessful) {
                Log.d("Main", "success!" + response.body().toString())
                profileState.value = response.body()!!.profile
            }
        }

        override fun onFailure(call: Call<UserModel?>, t: Throwable) {
            Log.e("Main", "Failed mate " + t.message.toString())
        }
    })
}