package kg.vohkysan.home_work6_1.data.storage.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kg.vohkysan.home_work6_1.data.storage.models.WordDataModel
import kg.vohkysan.home_work6_1.data.storage.models.WordDataModel.Companion.TABLE_NAME

@Dao
interface WordDao {

    @Insert
    fun addWord(word: WordDataModel)

    @Delete
    fun deleteWord(word: WordDataModel)

    //сортировка максимального значения по word_id УРАААААА
    @Query("SELECT * FROM $TABLE_NAME ORDER BY word_id DESC LIMIT 1")
    fun getWord(): WordDataModel

    @Query("SELECT * FROM $TABLE_NAME ORDER BY word_id ASC")
    fun getAll(): List<WordDataModel>

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAll()
}