package kg.vohkysan.home_work6_1.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kg.vohkysan.domain.repository.WordRepository
import kg.vohkysan.domain.usecase.DeleteWordUseCase
import kg.vohkysan.domain.usecase.GetWordUseCase
import kg.vohkysan.domain.usecase.SaveWordUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetWordUseCase(wordRepository: WordRepository): GetWordUseCase {
        return GetWordUseCase(wordRepository = wordRepository)
    }

    @Provides
    fun provideSaveWordUseCase(wordRepository: WordRepository): SaveWordUseCase {
        return SaveWordUseCase(wordRepository = wordRepository)
    }

    @Provides
    fun provideDeleteWordUseCase(wordRepository: WordRepository): DeleteWordUseCase {
        return DeleteWordUseCase(wordRepository = wordRepository)
    }
}