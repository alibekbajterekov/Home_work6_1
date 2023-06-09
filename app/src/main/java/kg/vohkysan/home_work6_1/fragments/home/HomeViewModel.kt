package kg.vohkysan.home_work6_1.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.vohkysan.domain.models.WordDomainModel
import kg.vohkysan.domain.usecase.DeleteWordUseCase
import kg.vohkysan.domain.usecase.GetWordUseCase
import kg.vohkysan.domain.usecase.SaveWordUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWordUseCase: GetWordUseCase,
    private val saveWordUseCase: SaveWordUseCase,
    private val deleteWordUseCase: DeleteWordUseCase
) : ViewModel() {

    private val resultMutableLive = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultMutableLive

    fun save(text: String) {
        val wordDomain = WordDomainModel(name = text)
        val resultData = saveWordUseCase.execute(wordDomain = wordDomain)
        resultMutableLive.value = resultData.toString()
    }

    fun load(): String {
        val wordDomain: WordDomainModel? = getWordUseCase.execute()
        return wordDomain?.name.toString()
    }

    fun delete() {
        deleteWordUseCase.execute()
    }
}