package data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(usuario : Usuario)

    @Update
    suspend fun update(usuario : Usuario)

    @Delete
    suspend fun delete(usuario : Usuario)

    @Query("SELECT * FROM usuarios WHERE id = :id")
    fun getUsuario(id : Int): Flow<Usuario>

    @Query("SELECT * FROM usuarios ORDER BY nome ASC")
    fun getTodosUsuarios(): Flow<List<Usuario>>
}