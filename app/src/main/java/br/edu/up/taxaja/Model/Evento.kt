package br.edu.up.taxaja.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import data.dao.StatusEvento
import java.util.Date

@Entity(tableName = "eventos")
data class Evento (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val nome : String,
    val data : Date,
    val horario : String,
    val descricao : String,
    val endereco : String,
    val valorPagarUsuario : Float,
    val isUrgent : Boolean,
    val status : StatusEvento,
    val imageResId: Int
) {
    constructor(nome: String, data: Date, horario: String, valorPagarUsuario: Float, status: StatusEvento, imageResId: Int) :
            this(0, nome, data, horario, "", "", valorPagarUsuario, false, status, imageResId)

    constructor() : this(0, "", Date(), "", "", "", 0.0f, false, StatusEvento.ATIVO, 0)

}