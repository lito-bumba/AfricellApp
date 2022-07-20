package com.litobumba.africellapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.litobumba.africellapp.ui.theme.coresBotao

@Composable
fun Texto(
    texto: String,
    cor: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Text(
        text = texto,
        color = cor,
        style = MaterialTheme.typography.body2,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun Botao(
    texto: String, imagem: Painter, click: () -> Unit = { }
) {
    Button(
        onClick = { click() },
        colors = coresBotao(),
        shape = RoundedCornerShape(20.dp),
        elevation = ButtonDefaults.elevation(8.dp),
        modifier = Modifier
            .height(125.dp)
            .width(100.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = imagem,
                contentDescription = "Imagem",
                modifier = Modifier.size(30.dp)
            )
            Text(texto, fontSize = 11.sp)
        }
    }
}

@Composable
fun InputText(
    texto: String = "",
    modifier: Modifier = Modifier,
    valueChanged: () -> Unit = {}
) {
    OutlinedTextField(
        value = texto,
        onValueChange = { valueChanged() },
        shape = RoundedCornerShape(30.dp),
        modifier = modifier.height(45.dp)
    )
}