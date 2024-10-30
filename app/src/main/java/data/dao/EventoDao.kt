package data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.up.taxaja.Model.Evento
import kotlinx.coroutines.flow.Flow

@Dao
interface EventoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(evento : Evento)

    @Update
    suspend fun update(evento : Evento)

    @Delete
    suspend fun delete(evento : Evento)

    @Query("SELECT * FROM eventos WHERE id = :id")
    fun getEvento(id : Int): Flow<Evento>

}