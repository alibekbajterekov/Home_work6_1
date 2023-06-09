package kg.vohkysan.home_work6_1.data.storage.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kg.vohkysan.home_work6_1.data.storage.models.WordDataModel.Companion.TABLE_NAME
import java.io.Serializable

@Entity(tableName = TABLE_NAME)
data class WordDataModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "word_id")
    val id: Int? = null,
    @ColumnInfo(name = "word_name")
    val name: String? = null
) : Serializable {
    companion object {
        const val TABLE_NAME = "words_table"
    }
}
