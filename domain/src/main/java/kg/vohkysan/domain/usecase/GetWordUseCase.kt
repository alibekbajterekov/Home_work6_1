package kg.vohkysan.domain.usecase

import kg.vohkysan.domain.models.WordDomainModel
import kg.vohkysan.domain.repository.WordRepository

class GetWordUseCase(private val wordRepository: WordRepository) {

    fun execute(): WordDomainModel? {
        return wordRepository.getWord()
    }
}