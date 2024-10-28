package data.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "enderecos")
data class Endereco (
    @PrimaryKey(autoGenerate = true) val id : Int,
    val cep : String,
    val rua : String,
    val numero : String,
    val bairro : String,
    val cidade : String,
    val uf : String,
    val userId : Int
) {
}