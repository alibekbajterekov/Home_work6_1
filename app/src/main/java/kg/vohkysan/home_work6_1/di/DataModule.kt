package kg.vohkysan.home_work6_1.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kg.vohkysan.domain.repository.WordRepository
import kg.vohkysan.home_work6_1.data.repository.WordRepositoryImpl
import kg.vohkysan.home_work6_1.data.storage.db.AppDataBase
import kg.vohkysan.home_work6_1.data.storage.db.WordDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "database-name")
            .allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideChannelDao(appDataBase: AppDataBase): WordDao {
        return appDataBase.wordDao()
    }

    @Provides
    @Singleton
    fun provideWordRepository(appDataBase: AppDataBase): WordRepository {
        return WordRepositoryImpl(appDataBase = appDataBase)
    }
}