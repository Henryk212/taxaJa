package data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.up.taxaja.Model.Grupo
import kotlinx.coroutines.flow.Flow

@Dao
interface GrupoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(grupo : Grupo)

    @Update
    suspend fun update(grupo : Grupo)

    @Delete
    suspend fun delete(grupo : Grupo)

    @Query("SELECT * FROM grupos WHERE id = :id")
    fun getEvento(id: Int): Flow<Grupo>
}