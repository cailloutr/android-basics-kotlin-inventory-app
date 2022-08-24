package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Query("SELECT * FROM item WHERE id = :id")
    fun getItemById(id: Int): Flow<Item>

    @Query("SELECT * FROM item ORDER BY name ASC")
    fun getAll(): Flow<List<Item>>

    @Delete
    suspend fun deleteItem(item: Item)

}