package com.example.p6

import android.annotation.SuppressLint
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun sRebuild(cursorQuery: Cursor): String {
    return buildString {
        while (cursorQuery.moveToNext()) {
            var id = cursorQuery.getInt(0)
            var name = cursorQuery.getString(1)
            var tempc: Double = cursorQuery.getDouble(2)
            append("$id $name $tempc \n")
            Log.d(
                "P11",
                "NAME: $name TEMP: $tempc\n!"
            )
        }
    }
}
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    lateinit var db: SQLiteDatabase
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        db = openOrCreateDatabase("P11.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS CITILAR (id INTEGER PRIMARY KEY, name TEXT, tempc REAL)")
        db.execSQL("INSERT OR IGNORE INTO CITILAR(name, tempc) VALUES ('Kazan', 0.3), ('Chelny', 1.0)")
        super.onCreate(savedInstanceState)
        setContent {
            var citiesCursor: Cursor = db.rawQuery("SELECT * FROM CITILAR;", null)
            var citiz =
                mutableStateOf(
                    sRebuild(
                        citiesCursor
                    )
                )
            val paddingModifier = Modifier.padding(10.dp)
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                Column {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.6f)
                            .padding(20.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        )
                    ) {
                        Text(citiz.value, modifier = Modifier.verticalScroll(ScrollState(0)))
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        )
                    ) {
                        Column {
                            var name by remember { mutableStateOf("") }
                            var tempc by remember { mutableStateOf<Double>(0.0) }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp),
                                verticalArrangement = Arrangement.SpaceAround
                            ) {
                                OutlinedTextField(
                                    value = name,

                                    onValueChange = { name = it },

                                    modifier = Modifier
                                        .fillMaxWidth(0.9f)
                                        .background(Color.Transparent),
                                    label = { Text(text = "City") },
                                    placeholder = { Text(text = "градусов ...") }
                                )

                                Spacer(modifier = Modifier.height(20.dp))

                                OutlinedTextField(
                                    value = tempc.toString(),

                                    onValueChange = { tempc = it.toDouble() },

                                    modifier = Modifier
                                        .fillMaxWidth(0.9f)
                                        .background(Color.Transparent),
                                    label = { Text(text = "Температура") },
                                    placeholder = { Text(text = "градусов ...") }
                                )

                                Spacer(modifier = Modifier.height(20.dp))

                                OutlinedButton(
                                    onClick = {
                                        db.execSQL("INSERT OR IGNORE INTO CITILAR(name, tempc) VALUES ('$name', '$tempc')")
                                    },

                                    modifier = Modifier.align(alignment = CenterHorizontally),

                                    elevation = ButtonDefaults.buttonElevation(
                                        defaultElevation = 5.dp,
                                        pressedElevation = 15.dp,
                                        disabledElevation = 10.dp,
                                        hoveredElevation = 15.dp,
                                        focusedElevation = 10.dp
                                    )
                                ) {

                                    Text("Добавить город")

                                }

                                OutlinedButton(
                                    onClick = {
                                        citiz.value =
                                            sRebuild(db.rawQuery("SELECT * FROM CITILAR;", null))
                                    },

                                    modifier = Modifier.align(alignment = CenterHorizontally),

                                    elevation = ButtonDefaults.buttonElevation(5.dp)
                                ) {
                                    Text("Recompose ")
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        db.close()
        deleteDatabase("P11.db")
        Log.d("SQLite", "БД уничтожено")
    }
}