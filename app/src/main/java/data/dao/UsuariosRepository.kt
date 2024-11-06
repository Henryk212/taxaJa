package data.dao

import br.edu.up.taxaja.Model.Usuario
import kotlinx.coroutines.flow.Flow

interface UsuariosRepository {
    fun getUsuarioStream(id : Int): Flow<Usuario?>
    fun getAllUsuariosStream(): Flow<List<Usuario>>

    suspend fun insertUsuario(usuario : Usuario)
    suspend fun updateUsuario(usuario : Usuario)
    suspend fun deleteUsuario(usuario : Usuario)
}