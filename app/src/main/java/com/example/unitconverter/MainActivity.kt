package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  UnitConverter(
                       modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun UnitConverter(modifier: Modifier = Modifier){
    Column {
        //Here all the UI elements will be stacked below each other
        Text(text = "Unit Converter")
        OutlinedTextField(value = "Unit Value", onValueChange = {//Here goes what should happen when the value of our OutlinedTextField changes
            })

        Row {
            val context = LocalContext.current
            //Here all the UI elements will be stacked next to each other
            Button(onClick = { Toast.makeText(
                context, "Thanks for clicking!",
                Toast.LENGTH_LONG).show() })
            {
                Text(text = "Click Me!")

            }

        }
        
        Text(text = "Result: ")
    }

}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
       UnitConverterTheme {
           UnitConverter()
       }

}