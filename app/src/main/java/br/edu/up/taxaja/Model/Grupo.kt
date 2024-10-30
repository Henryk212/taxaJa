package br.edu.up.taxaja.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grupos")
data class Grupo (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nome : String

) {
}