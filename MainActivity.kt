package com.example.aulacontroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aulacontroller.ui.theme.AulaControllerTheme
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import android.R.attr.onClick
import androidx.compose.material3.Button
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navigationController = rememberNavController()

            NavHost(navController = navigationController,
                startDestination = "/tela01")
            {
                composable("/tela01"){
                    Tela(
                        "Tela 01",
                        clickAnterior = { },
                        clickProximo = {
                            navigationController.navigate("/tela02")
                        }
                    )
                }
                composable("/tela02"){
                    Tela(
                        "Tela 02",
                        clickAnterior = { },
                        clickProximo = {  navigationController.navigate("/tela03") }
                    )
                }
                composable("/tela03"){
                    Tela(
                        "Tela 03",
                        clickAnterior = { },
                        clickProximo = {
                            navigationController.navigate("/tela01")
                            navigationController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Tela(nomeDaTela: String = "Tela Home",
         clickAnterior: () -> Unit,
         clickProximo: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(text = nomeDaTela, fontSize = 36.sp)
        Button(clickProximo){
            Text("proxima Tela")
        }
        Text(nomeDaTela)
        Button(clickAnterior){
            Text("tela Anterior")
        }

    }

}
