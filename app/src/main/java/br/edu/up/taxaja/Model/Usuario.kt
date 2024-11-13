package br.edu.up.taxaja.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    val nome : String,

    val email : String,

    val telefone : String,

    val nomeUsuario : String,

    val senha : String,

    val sexo : String
) {

}