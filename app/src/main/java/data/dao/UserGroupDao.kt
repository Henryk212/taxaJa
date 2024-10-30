package data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.up.taxaja.Model.UserGroup
import kotlinx.coroutines.flow.Flow

@Dao
interface UserGroupDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(userGroup : UserGroup)

    @Update
    suspend fun update(userGroup : UserGroup)

    @Delete
    suspend fun delete(userGroup : UserGroup)

    @Query("SELECT * FROM user_group WHERE id = :id")
    fun getUserGroup(id : Int): Flow<UserGroup>
}