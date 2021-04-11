package com.example.itunes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.itunes.data.ItuneDto
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideoDetail(ituneDto: ItuneDto)

    @Query("SELECT * FROM video_detail")
    fun fetchVideoHistory(): Flow<List<ItuneDto>>
}