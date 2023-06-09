package kg.vohkysan.home_work6_1.data.repository

import kg.vohkysan.domain.models.WordDomainModel
import kg.vohkysan.domain.repository.WordRepository
import kg.vohkysan.home_work6_1.data.storage.db.AppDataBase
import kg.vohkysan.home_work6_1.data.storage.models.WordDataModel

class WordRepositoryImpl(private val appDataBase: AppDataBase) : WordRepository {
    override fun saveWord(wordDomain: WordDomainModel) {
        val wordData = mapToStorage(wordDomain)
        appDataBase.wordDao().addWord(wordData)
    }

    override fun getWord(): WordDomainModel? {
        val wordData = appDataBase.wordDao().getWord()
        return mapToDomain(wordData)
    }

    override fun deleteAllWords() {
        appDataBase.wordDao().deleteAll()
    }

    private fun mapToStorage(wordDomain: WordDomainModel): WordDataModel {
        return WordDataModel(name = wordDomain.name)
    }

    private fun mapToDomain(wordData: WordDataModel): WordDomainModel? {
        return wordData.name?.let { WordDomainModel(it) }
    }
}