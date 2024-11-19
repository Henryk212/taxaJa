package br.edu.up.taxaja.ViewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import br.edu.up.taxaja.Model.Evento
import br.edu.up.taxaja.R
import data.dao.StatusEvento

class HomeViewModel : ViewModel() {
    private val _eventos = mutableStateOf<List<Evento>>(listOf(
        Evento(
            id = 1,
            nome = "Rock Concert",
            data = "10/09/1193",
            horario = "20:00",
            descricao = "A great rock concert.",
            endereco = "Rock Arena",
            valorPagarUsuario = 100.0f,
            isUrgent = false,
            status = StatusEvento.ATIVO,
            imageResId = R.drawable.imagem1
        ),
        Evento(
            id = 2,
            nome = "Jazz Night",
            data = "10/09/1193",
            horario = "19:00",
            descricao = "Smooth jazz night.",
            endereco = "Jazz Club",
            valorPagarUsuario = 80.0f,
            isUrgent = false,
            status = StatusEvento.ATIVO,
            imageResId = R.drawable.imagem1 // ID do recurso drawable
        ),
        Evento(
            id = 3,
            nome = "Pop Festival",
            data = "10/09/1193",
            horario = "18:00",
            descricao = "A fun pop music festival.",
            endereco = "Festival Grounds",
            valorPagarUsuario = 120.0f,
            isUrgent = true,
            status = StatusEvento.ATIVO,
            imageResId = R.drawable.imagem1 // ID do recurso drawable
        )
    ))
    val eventos: State<List<Evento>> = _eventos // Lista de eventos
}