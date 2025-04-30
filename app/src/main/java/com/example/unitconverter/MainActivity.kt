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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

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

    var inputValue by remember { mutableStateOf("")}
    var outputValue by remember { mutableStateOf("")}
    var inputUnit by remember { mutableStateOf("Meters")}
    var outputUnit by remember { mutableStateOf("Meters")}
    var iExpanded by remember { mutableStateOf(false)}
    var oExpanded by remember { mutableStateOf(false)}
    val iConversionFactor = remember { mutableStateOf(1.0)}
    val oConversionFactor = remember { mutableStateOf(1.0)}

    fun ConvertUnits(){

        //'?:' -> elvis operator = if the user enter anything not a double it is default change to 0.0
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * iConversionFactor.value * 100.0 / oConversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.asPaddingValues()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally

    ){
        //Here all the UI elements will be stacked below each other
        Text(text = "Unit Converter", modifier = Modifier.padding(80.dp))
        OutlinedTextField(value = inputValue, onValueChange = {//Here goes what should
                                        // happen when the value of our OutlinedTextField changes
            inputValue = it
            ConvertUnits()
            },
            label = { Text("Enter a value here")})

        Spacer(modifier = Modifier.height(16.dp))

        Row {

            //Input Box
            //Here all the UI elements will be stacked next to each other
            Box{
                //Input Button
                Button(onClick = {iExpanded = true}) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = {iExpanded = false}) {
                    DropdownMenuItem(text = { Text(
                        text = "Millimeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Millimeters"
                            iConversionFactor.value = 0.001
                            ConvertUnits()
                        })
                    DropdownMenuItem(text = { Text(
                        text = "Centimeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeters"
                            iConversionFactor.value = 0.01
                            ConvertUnits()
                        })
                    DropdownMenuItem(text = { Text(
                        text = "Meters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Meters"
                            iConversionFactor.value = 1.0
                            ConvertUnits()
                        })
                    DropdownMenuItem(text = { Text(
                        text = "Inches")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Inches"
                            iConversionFactor.value = 0.0254
                            ConvertUnits()
                        })
                    DropdownMenuItem(text = { Text(
                        text = "Feet")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Feet"
                            iConversionFactor.value = 0.3048
                            ConvertUnits()
                        })
                }
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            //Output Box
            Box{
                //Output Button
                Button(onClick = {oExpanded = true}) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text(
                        text = "Millimeters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Millimeter"
                            oConversionFactor.value = 0.001
                            ConvertUnits()
                        })
                    DropdownMenuItem(text = { Text(
                        text = "Centimeters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centimeters"
                            oConversionFactor.value = 0.01
                            ConvertUnits()
                        })
                    DropdownMenuItem(text = { Text(
                        text = "Meters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Meters"
                            oConversionFactor.value = 1.0
                            ConvertUnits()
                        })
                   DropdownMenuItem(text = { Text(
                        text = "Inches")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Inches"
                            oConversionFactor.value = 0.0254
                            ConvertUnits()
                        })
                    DropdownMenuItem(text = { Text(
                        text = "Feet")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Feet"
                            oConversionFactor.value = 0.3048
                            ConvertUnits()
                        })
                }
            }
        
        }
        Spacer(modifier = Modifier.height(36.dp))
        Text(text = "Result: $outputValue $outputUnit")
    }

}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
       UnitConverterTheme {
           UnitConverter()
       }

}