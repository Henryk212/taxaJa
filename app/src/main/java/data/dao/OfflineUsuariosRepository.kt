package data.dao

import br.edu.up.taxaja.Model.Usuario
import kotlinx.coroutines.flow.Flow

class OfflineUsuariosRepository (private val usuarioDao : UsuarioDao) : UsuariosRepository{

    override fun getAllUsuariosStream(): Flow<List<Usuario>> = usuarioDao.getTodosUsuarios()
    override fun getUsuarioStream(id: Int): Flow<Usuario?> = usuarioDao.getUsuario(id)

    override suspend fun insertUsuario(usuario: Usuario) = usuarioDao.insert(usuario)

    override suspend fun updateUsuario(usuario: Usuario) = usuarioDao.update(usuario)

    override suspend fun deleteUsuario(usuario: Usuario) = usuarioDao.delete(usuario)
}