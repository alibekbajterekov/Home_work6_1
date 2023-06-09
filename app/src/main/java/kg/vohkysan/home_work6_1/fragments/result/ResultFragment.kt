package kg.vohkysan.home_work6_1.fragments.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.room.RoomDatabase
import dagger.hilt.android.AndroidEntryPoint
import kg.vohkysan.home_work6_1.R
import kg.vohkysan.home_work6_1.databinding.FragmentResultBinding

@AndroidEntryPoint
class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val resultViewModel: ResultViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        with(binding) {
            etWord.setText(resultViewModel.load())
            if (etWord.text?.isEmpty() == true) {
                Toast.makeText(context, "Edit text is empty", Toast.LENGTH_SHORT).show()
            } else {
                btnPrevFragment.setOnClickListener {
                    val word = etWord.text.toString()
                    resultViewModel.save(word)
                    findNavController().navigateUp()
                }
            }
        }
    }
}