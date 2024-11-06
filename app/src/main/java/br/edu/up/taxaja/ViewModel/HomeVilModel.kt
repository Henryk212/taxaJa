package br.edu.up.taxaja.ViewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import br.edu.up.taxaja.Model.Evento
import data.dao.StatusEvento
import java.util.Date

class HomeViewModel : ViewModel() {
    private val _eventos = mutableStateOf(listOf(
        Evento(1, "Show Mamonas Assassinas", Date(), "20:00", "Descrição do evento", "Endereço do evento", 100.0f, false, StatusEvento.ATIVO),
        Evento(2, "Show Legião Urbana", Date(), "21:00", "Descrição do evento", "Endereço do evento", 150.0f, false, StatusEvento.INATIVO),
        Evento(3, "Show Titãs", Date(), "22:00", "Descrição do evento", "Endereço do evento", 120.0f, false, StatusEvento.CANCELADO)
    ))
    val eventos: State<List<Evento>> = _eventos
}