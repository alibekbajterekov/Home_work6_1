package kg.vohkysan.domain.repository

import kg.vohkysan.domain.models.WordDomainModel

interface WordRepository {

    fun saveWord(wordDomain: WordDomainModel)
    fun getWord(): WordDomainModel?
    fun deleteAllWords()
}