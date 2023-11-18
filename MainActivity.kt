package com.example.p6

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    lateinit var db: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        db = openOrCreateDatabase("P11.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS CITILAR (id INTEGER PRIMARY KEY, name TEXT, tempc REAL)")
        db.execSQL("INSERT OR IGNORE INTO CITILAR(name, tempc) VALUES ('KAZAN', 0.3), ('CHELNY', 1.0), ('AGRYZ', -0.1)")
        val query: String = "SELECT * FROM CITILAR;"
        val cursor: Cursor = db.rawQuery(query, null)
        var citiz = buildString {
            while (cursor.moveToNext()) {
                var id = cursor.getInt(0)
                var name = cursor.getString(1)
                var tempc: Double = cursor.getDouble(2)
                append("$id $name $tempc \n")
                Log.d(
                    "P11", "NAME: $name TEMP: $tempc\n!"
                )
            }
        }
        super.onCreate(savedInstanceState)
        setContent {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
                    .padding(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {
                Text(citiz, modifier = Modifier.verticalScroll(ScrollState(1)))
            }
        }
    }
    override fun onDestroy() {
        db.close()
        deleteDatabase("P11.db")
        super.onDestroy()
    }
}