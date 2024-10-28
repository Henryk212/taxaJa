package data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EnderecoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(endereco : Endereco)

    @Update
    suspend fun update(endereco : Endereco)

    @Query("SELECT * FROM enderecos WHERE id = :id")
    fun getEndereco(id : Int): Flow<Endereco>

    @Query("SELECT * FROM enderecos ORDER BY uf ASC")
    fun getTodosEnderecos(): Flow<List<Endereco>>

}