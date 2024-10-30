package br.edu.up.taxaja.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity (
    tableName = "user_event",
    foreignKeys = [
        ForeignKey(entity = Usuario::class, parentColumns = ["id"], childColumns = ["idUsuario"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Evento::class, parentColumns = ["id"], childColumns = ["idEvento"], onDelete = ForeignKey.CASCADE)
    ]
)

data class UserEvent (
    @PrimaryKey(autoGenerate = true)
    val id : Int= 0,
    val idUsuario : Int,
    val idGrupo : Int
){
}