package com.example.p6

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.p6.ui.theme.P6Theme
import org.json.JSONObject

const val API_KEY = "b9bdda6e75f149795d100950231008"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate (savedInstanceState)
        setContent {
            P6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                Greeting("Kazan", this)
            }
            }
        }
    }
}


@Composable
fun Greeting(name: String, context: Context) {
    val state = remember { mutableStateOf("Неопределенный населенный пункт ....") }
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Temp in $name ${state.value} C")
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ){
                Button(
                    onClick = {
                        getResult(name, state, context)
                    },
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Обновить")
                }
            }
        }
    }
}

private fun getResult(city: String, state: MutableState<String>, context: Context){
    val url = "http://api.weatherapi.com/vi/current.json" +
            "?key=$API_KEY" +
            "&q = $city" +
            "&aqi=no"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        {

            response ->
            val obj=JSONObject(response)
            state.value=obj.getJSONObject("current").getString("temp_c")
        },
        {
            error -> Log.d("Sh1", "Error $error")
        }
    )
    queue.add(stringRequest)
}
