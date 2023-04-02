package com.willian.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue // for by
import androidx.compose.runtime.setValue // for by
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.willian.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    MyBox()
//                    MyColumn()
//                    MyRow()
//                    MyComplexLayout()
//                    MyStateExample()
//                    MyText()

//                    var myText by remember {
//                        mutableStateOf("Wiilian")
//                    }
//                    MyTextField(myText) {myText = it}

//                    MyTextFieldAdvance()
//                    Column() {
//                        MyTextFieldOutlined()
//                    }
//                    MyButtonExample()
//                    MyProgress()
                    MyProgressAdvance()
                }
            }
        }
    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 3")
        }

        MySpacer(width = 0, height = 30)

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                //mas elementos
                Text(text = "Ejemplo 1")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Blue), contentAlignment = Alignment.Center
            ) {
                //mas elementos
                Text(text = "Ejemplo 2")
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Green), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 5")
        }
    }
}

@Composable
fun MySpacer(width: Int?, height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

@Composable
fun MyRow() {
//    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
//        Text(text = "Ejemplo 1")
//        Text(text = "Ejemplo 2")
//        Text(text = "Ejemplo 3")
//    }

//    Row(Modifier.fillMaxSize()) {
//        // Trabajando con pesos, cada elemento ocupa un espacio proporcional en pantalla segun el peso
//        // indicado
//        Text(text = "Ejemplo 1", modifier = Modifier.weight(1f))
//        Text(text = "Ejemplo 2", modifier = Modifier.weight(1f))
//        Text(text = "Ejemplo 3", modifier = Modifier.weight(1f))
//    }

    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        // Trabajando con dp fijos, cada elemento ocupa el espacio indicado en medida
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 2", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 2", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 2", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier.width(100.dp))
    }
}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 2", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 3", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 4", modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 2", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 3", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 4", modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Esto es un ejemplo")
        }
    }
}

// trabajando con estado o recomposicion

@Composable
fun MyStateExample() {

//    var counter = remember { mutableStateOf(0) } // recupera el valor cada vez que se recrea
    var counter by rememberSaveable { mutableStateOf(0) }  // recupera el estado aunque la activity se destruya

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${counter} veces")
    }

}

// componentes
// 1. TextView
@Composable
fun MyText() {

//    Forma 1: usando el TextStyle

//    Column(Modifier.fillMaxSize()) {
//        Text(text = "Esto es un ejemplo")
//        Text(text = "Esto es un ejemplo de color", color = Color.Blue)
//        Text(text = "Esto es un ejemplo con bold", fontWeight = FontWeight.ExtraBold)
//        Text(text = "Esto es un ejemplo con light", fontWeight = FontWeight.Light)
//        Text(
//            text = "Esto es un ejemplo con style",
//            style = TextStyle(fontFamily = FontFamily.Cursive)
//        )
//        Text(
//            text = "Esto es un ejemplo con decoration",
//            style = TextStyle(textDecoration = TextDecoration.LineThrough)
//        )
//        Text(
//            text = "Esto es un ejemplo con decoration",
//            style = TextStyle(textDecoration = TextDecoration.Underline)
//        )
//        Text(
//            text = "Esto es un ejemplo con decoration combine", style = TextStyle(
//                textDecoration = TextDecoration.combine(
//                    listOf(
//                        TextDecoration.LineThrough, TextDecoration.Underline
//                    )
//                )
//            )
//        )
//    }

//    Forma 2
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo de color", color = Color.Blue)
        Text(text = "Esto es un ejemplo con bold", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo con light", fontWeight = FontWeight.Light)
        Text(
            text = "Esto es un ejemplo con style",
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = "Esto es un ejemplo con decoration",
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "Esto es un ejemplo con decoration",
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "Esto es un ejemplo con decoration combine",
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough, TextDecoration.Underline
                )
            )
        )
        Text(text = "Este es el ultimo ejemplo", fontSize = 30.sp)
    }

}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember {
        mutableStateOf("Wiilian")
    }
    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text(text = "Introduce tu nombre") })
}

//    Pasandole valores mediante parametros y ejecutando accion con lambda
@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChanged(it) })
}

// TextFiel con material
@Composable
fun MyTextFieldOutlined() {
    var myText by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Holita") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyButtonExample() { // botones
    // estados
    var enabled by rememberSaveable { // mantiene el estado aunque se rote la pantalla
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled, // deshabilita o habilita el boton
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola!!!")
        }
        
        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled, // deshabilita o habilita el boton
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta,
            contentColor = Color.Blue,
                disabledBackgroundColor = Color.Blue, // colores segun estado de los botones
                disabledContentColor = Color.Red
            ),
        ) {
            Text(text = "Hola!!!")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Hola desde textbutton") // el boton no va tener borde nunca
        }
    }
}

@Composable
fun MyImage() {
//    sustituye al componente imageView en xml
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Icono",
        tint = Color.Red
    )
}

@Composable
fun MyProgressAdvance() {
    var progressStatus by rememberSaveable {
        mutableStateOf(0f)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progressStatus)
        
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { progressStatus += 0.1f }) {
                Text(text = "Incrementar")
            }
            Button(onClick = { progressStatus -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable {
        mutableStateOf( false )
    }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 32.dp),
            color = Color.Red,
            backgroundColor = Color.Green
        )
    }
    
    Button(onClick = { showLoading = !showLoading }) {
        Text(text = "Cargar Perfil")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogTheme {
//        MyBox()
//        MyColumn()
//        MyRow()
//        MyComplexLayout()
//        MyStateExample()
//        MyText()
//        MyTextField()
//        MyTextFieldAdvance()
//        MyTextFieldOutlined()
//        MyButtonExample()
//        MyImage()
//        MyImageAdvance()
//        MyIcon()
//        MyProgress()
        MyProgressAdvance()
    }
}