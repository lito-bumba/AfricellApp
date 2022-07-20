package com.litobumba.africellapp.ui.theme

import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val corPrimaria = Color(0xFFBD0D79)
val corSecundaria = Color(0x9EBD0D79)

@Composable
fun coresBotao(): ButtonColors = ButtonDefaults.buttonColors(
    backgroundColor = corPrimaria,
    contentColor = Color.White
)