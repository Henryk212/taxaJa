package br.edu.up.taxaja.View.Adapter

import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.recyclerview.widget.RecyclerView
import br.edu.up.taxaja.Model.Evento
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter

class EventoAdapter(private val eventos: List<Evento>) : RecyclerView.Adapter<EventoAdapter.EventoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        return EventoViewHolder(ComposeView(parent.context))
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        holder.bind(eventos[position])
    }

    override fun getItemCount(): Int = eventos.size

    class EventoViewHolder(itemView: ComposeView) : RecyclerView.ViewHolder(itemView) {
        fun bind(evento: Evento) {
            (itemView as ComposeView).setContent {
                EventoCard(evento)
            }
        }
    }
}

@Composable
fun EventoCard(evento: Evento) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { /* Handle click */ }
    ) {
        // Background image
        Image(
            painter = rememberImagePainter(data = evento.imageResId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Content overlay
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
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