package kg.vohkysan.domain.usecase

import kg.vohkysan.domain.models.WordDomainModel
import kg.vohkysan.domain.repository.WordRepository

class SaveWordUseCase(private val wordRepository: WordRepository) {

    fun execute(wordDomain: WordDomainModel) {
        wordRepository.saveWord(wordDomain)
    }
}