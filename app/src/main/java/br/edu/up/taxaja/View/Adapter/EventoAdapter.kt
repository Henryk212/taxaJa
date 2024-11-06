package br.edu.up.taxaja.View.Adapter

import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.recyclerview.widget.RecyclerView
import br.edu.up.taxaja.Model.Evento

class EventoAdapter(private val eventos: List<Evento>) : RecyclerView.Adapter<EventoAdapter.EventoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        return EventoViewHolder()
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        holder.bind(eventos[position])
    }

    override fun getItemCount(): Int = eventos.size

    class EventoViewHolder : RecyclerView.ViewHolder(ComposeView(parent.context)) {
        fun bind(evento: Evento) {
            (itemView as ComposeView).setContent {
                EventoCard(evento)
            }
        }
    }

    @Composable
    fun EventoCard(evento: Evento) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { /* Handle click */ }
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