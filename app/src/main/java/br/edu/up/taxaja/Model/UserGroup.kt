package br.edu.up.taxaja.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_group",
    foreignKeys = [
        ForeignKey(entity = Usuario::class, parentColumns = ["id"], childColumns = ["idUsuario"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Grupo::class, parentColumns = ["id"], childColumns = ["idGrupo"], onDelete = ForeignKey.CASCADE)
    ])
data class UserGroup (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val idUsuario : Int,
    val idGrupo : Int
) {

}