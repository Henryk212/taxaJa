package data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.up.taxaja.Model.UserEvent
import kotlinx.coroutines.flow.Flow

@Dao
interface UserEventDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(userEvent : UserEvent)

    @Update
    suspend fun update(userEvent : UserEvent)

    @Delete
    suspend fun delete(userEvent : UserEvent)

    @Query("SELECT * FROM user_event WHERE id = :id")
    fun getUserEvent(id : Int): Flow<UserEvent>
}