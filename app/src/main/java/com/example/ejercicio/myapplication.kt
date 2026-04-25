package com.example.ejercicio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Ejemplo Contenedores y Controles") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            item { Text("📦 Contenedores", style = MaterialTheme.typography.titleMedium) }

            item {
                LazyRow {
                    items(5) { index ->
                        Card(
                            Modifier
                                .padding(4.dp)
                                .size(60.dp)
                        ) {
                            Text("Item $index", Modifier.padding(8.dp))
                        }
                    }
                }
            }

            item { Spacer(Modifier.height(16.dp)) }

            item { Text("🎛 Controles", style = MaterialTheme.typography.titleMedium) }

            item { ControlCheckboxDemo() }
            item { ControlRadioButtonDemo() }
            item { ControlSliderDemo() }
            item { ControlButtonDemo() }
        }
    }
}

// -------- Controles básicos ----------

@Composable
fun ControlCheckboxDemo() {
    var checked by remember { mutableStateOf(false) }
    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        Text("Checkbox seleccionado: $checked")
    }
}

@Composable
fun ControlRadioButtonDemo() {
    var selected by remember { mutableStateOf(false) }
    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
        RadioButton(selected = selected, onClick = { selected = !selected })
        Text("RadioButton activo: $selected")
    }
}

@Composable
fun ControlSliderDemo() {
    var value by remember { mutableStateOf(0f) }
    Column {
        Slider(value = value, onValueChange = { value = it })
        Text("Valor del Slider: ${"%.2f".format(value)}")
    }
}

@Composable
fun ControlButtonDemo() {
    Button(onClick = {}) {
        Text("Soy un botón")
    }
}
