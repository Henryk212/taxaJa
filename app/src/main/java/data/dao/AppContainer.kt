package data.dao

import android.content.Context

interface AppContainer {
    val usuariosRepository : UsuariosRepository
}

class AppdataContainer(private val context: Context) : AppContainer {
    override val usuariosRepository : UsuariosRepository by lazy {
        OfflineUsuariosRepository(taxaJaApp.getDatabase(context).usuarioDao())
    }
}