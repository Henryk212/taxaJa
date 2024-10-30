package data.dao

import androidx.room.Database
import br.edu.up.taxaja.Model.Endereco
import br.edu.up.taxaja.Model.Grupo
import br.edu.up.taxaja.Model.UserGroup
import br.edu.up.taxaja.Model.Usuario

@Database(entities = [Usuario::class, Endereco::class, Grupo::class, UserGroup::class], version =1)
abstract class taxaJaApp {
}