package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
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
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.asPaddingValues()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally

    ){
        //Here all the UI elements will be stacked below each other
        Text(text = "Unit Converter", modifier = Modifier.padding(80.dp))
        OutlinedTextField(value = "Unit Value", onValueChange = {//Here goes what should
                                        // happen when the value of our OutlinedTextField changes
            })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            //Here all the UI elements will be stacked next to each other
            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Centimeters")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(
                        text = "Millimeters")},
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(
                        text = "Meters")},
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(
                        text = "Inches")},
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(
                        text = "Feet")},
                        onClick = { /*TODO*/ })
                }
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Meters")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(
                        text = "Milimeters")},
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(
                        text = "Centimeters")},
                        onClick = { /*TODO*/ })
                   DropdownMenuItem(text = { Text(
                        text = "Inches")},
                        onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(
                        text = "Feet")},
                        onClick = { /*TODO*/ })
                }
            }
        
        }
        Spacer(modifier = Modifier.height(36.dp))
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