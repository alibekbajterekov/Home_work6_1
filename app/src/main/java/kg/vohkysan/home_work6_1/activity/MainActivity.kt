package kg.vohkysan.home_work6_1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import kg.vohkysan.home_work6_1.R
import kg.vohkysan.home_work6_1.databinding.ActivityMainBinding

/* Вопросы:
* 1) Когда мы используем модули, то мы внедряем зависимости в gradle модулях, те которые используются или везде надо внедрять?
* 2) Надо ли под каждый fragment, activity создавать и использовать свою viewModel
* или достаточно создать одну и если функционал одинаковый, то переиспользовать?
* 3) Не совсем понял с применением интерфейса в domain, правильн понимаю, что так как мы используем в useCase интерфейс,
* то когда мы используем методы из интерфейса, android studio видит, реализацию его в repositoryImpl класса data и использует оттуда?
* */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}