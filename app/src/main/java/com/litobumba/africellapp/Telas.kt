package com.litobumba.africellapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices.PIXEL_4
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.litobumba.africellapp.ui.theme.AfricellAppTheme
import com.litobumba.africellapp.ui.theme.corPrimaria
import com.litobumba.africellapp.ui.theme.coresBotao
import kotlinx.coroutines.delay


@Composable
fun TelaSplash(navegar: () -> Unit) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navegar()
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(corPrimaria)
    ) {
        Image(
            painterResource(R.drawable.africell_logo_white),
            contentDescription = "Logo",
            modifier = Modifier.size(230.dp)
        )
    }
}

@Composable
fun TelaPrincipal() {
    Scaffold(
        topBar = { TopBar() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Texto(
                    texto = "Olá, Martin",
                    cor = corPrimaria
                )
            }

            Card(shape = RoundedCornerShape(15.dp)) {
                Image(
                    painterResource(id = R.drawable.home_img_2),
                    contentDescription = "Home Image",
                    modifier = Modifier
                        .height(198.dp)
                        .fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .height(80.dp)
                    .alpha(.62f),
                contentColor = Color.White,
                backgroundColor = corPrimaria
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 15.dp, vertical = 15.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(.39f)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Texto(texto = "Saldo disponível", cor = Color.White)
                        Texto(texto = "Numero Telefone", cor = Color.White)
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(.43f)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Texto(texto = "15GB", cor = Color.White)
                        Texto(texto = "951233232", cor = Color.White)
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(.29f)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Image(
                            painter = painterResource(R.drawable.home_wallet),
                            contentDescription = "Wallet",
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Column(modifier = Modifier.fillMaxWidth(.9f)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Botao(
                        texto = "Internet",
                        imagem = painterResource(R.drawable.home_pix)
                    ) { }

                    Botao(
                        texto = "Pacotes",
                        imagem = painterResource(R.drawable.home_barcode)
                    ) { }

                    Botao(
                        texto = "Recarregar",
                        imagem = painterResource(R.drawable.home_dollar)
                    ) { }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Botao(
                        texto = "Encontre Lojas",
                        imagem = painterResource(R.drawable.home_pix)
                    ) { }

                    Botao(
                        texto = "Nossa Carreira",
                        imagem = painterResource(R.drawable.home_barcode)
                    ) { }

                    Botao(
                        texto = "Social Mídias",
                        imagem = painterResource(R.drawable.home_dollar)
                    ) { }
                }
            }
        }
    }
}

@Composable
private fun TopBar() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.africell_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(25.dp)
                    .width(100.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.home_settings),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(25.dp)
                    .width(30.dp)
            )
        }
    }
}

@Composable
fun TelaLogin(navegar: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (image, detail) = createRefs()
        Image(
            painter = painterResource(R.drawable.login_img_1), contentDescription = "Imagem",
            modifier = Modifier
                .width(200.dp)
                .height(307.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
        )

        LoginDetails(
            navegar = navegar,
            Modifier.constrainAs(detail) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
    }
}

@Composable
private fun LoginDetails(navegar: () -> Unit, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(.56f)
    ) {
        Image(
            painter = painterResource(R.drawable.africell_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .width(200.dp)
                .height(80.dp)
        )

        Column {
            Texto(texto = "Número de telemóvel", modifier = Modifier.padding(start = 15.dp))
            Spacer(modifier = Modifier.height(8.dp))
            InputText()

            Spacer(modifier = Modifier.height(20.dp))

            Texto(texto = "Palavra-passe", modifier = Modifier.padding(start = 15.dp))
            Spacer(modifier = Modifier.height(8.dp))
            InputText()
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { navegar() },
            shape = RoundedCornerShape(25.dp),
            colors = coresBotao(),
            modifier = Modifier
                .fillMaxWidth(.6f)
                .height(50.dp)
        ) { Texto("Entrar", Color.White) }
    }
}

@Preview
@Composable
fun VerTelaSplash() {
    TelaSplash { }
}

@Preview(
    showBackground = true,
    device = PIXEL_4
)
@Composable
fun VerTelaLogin() {
    TelaLogin { }
}

@Preview(showBackground = true)
@Composable
fun VerTelaPrincipal() {
    AfricellAppTheme {
        TelaPrincipal()
    }
}