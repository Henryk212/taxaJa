package data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.up.taxaja.Model.Endereco
import br.edu.up.taxaja.Model.Evento
import br.edu.up.taxaja.Model.Grupo
import br.edu.up.taxaja.Model.UserEvent
import br.edu.up.taxaja.Model.UserGroup
import br.edu.up.taxaja.Model.Usuario

@Database(
    entities = [Usuario::class, Endereco::class, Grupo::class, UserGroup::class, Evento::class, UserEvent::class],
    version =1,
    exportSchema = false
)
abstract class taxaJaApp : RoomDatabase (){
    abstract fun usuarioDao() : UsuarioDao
    abstract fun enderecoDao() : EnderecoDao
    abstract fun grupoDao() : GrupoDao
    abstract fun userGroupDao() : UserGroupDao
    abstract fun eventoDao(): EventoDao
    abstract fun userEventDao(): UserEventDao

    companion object {
        @Volatile
        private var instance : taxaJaApp? = null
        fun getDatabase(context: Context): taxaJaApp {
            return instance ?: synchronized(this) {
                instance ?: Room
                    .databaseBuilder(context.applicationContext, taxaJaApp::class.java, "taxa_ja_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }
        }
    }
}