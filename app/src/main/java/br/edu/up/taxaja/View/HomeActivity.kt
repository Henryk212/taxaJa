package br.edu.up.taxaja.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.taxaja.Model.Evento
import br.edu.up.taxaja.ViewModel.HomeViewModel
import br.edu.up.taxaja.ui.theme.TaxaJaTheme

class HomeActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaxaJaTheme {
                HomeScreen(homeViewModel)
            }
        }
    }

    @Composable
    fun Header() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Taxa Já",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

    @Composable
    fun HomeScreen(viewModel: HomeViewModel) {
        val eventos by viewModel.eventos

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Header() // Add the header here

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(text = "Bem-vindo, [Nome do Usuário]!", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

                LazyColumn {
                    items(eventos.size) { index ->
                        val evento = eventos[index]
                        EventoCard(evento)
                    }
                }
            }
        }
    }

    @Composable
    fun EventoCard(evento: Evento) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { /* Handle click */ },
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp) // Increase height to accommodate buttons
            ) {
                // Imagem de fundo
                Image(
                    painter = painterResource(id = evento.imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp)), // Clip the image to the card's shape
                    contentScale = ContentScale.Crop
                )

                // Conteúdo sobreposto
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = evento.nome, fontSize = 18.sp, modifier = Modifier.padding(bottom = 4.dp))
                    Text(text = evento.data.toString(), modifier = Modifier.padding(bottom = 4.dp))
                    Text(text = evento.horario, modifier = Modifier.padding(bottom = 4.dp))
                    Text(text = "R$ ${evento.valorPagarUsuario}", modifier = Modifier.padding(bottom = 4.dp))
                    Text(text = evento.status.toString(), modifier = Modifier.padding(bottom = 8.dp))

                    Row {
                        Button(onClick = { /* Lógica para favoritar o evento */ }) {
                            Text("Favoritar")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = { /* Lógica para inscrever-se no evento */ }) {
                            Text("Inscrever-se")
                        }
                    }
                }
            }
        }
    }
}