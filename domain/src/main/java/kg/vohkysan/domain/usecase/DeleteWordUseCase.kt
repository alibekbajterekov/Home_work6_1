package kg.vohkysan.domain.usecase

import kg.vohkysan.domain.repository.WordRepository

class DeleteWordUseCase(private val wordRepository: WordRepository) {

    fun execute() {
        wordRepository.deleteAllWords()
    }
}