package kg.vohkysan.home_work6_1.fragments.home

import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kg.vohkysan.home_work6_1.R
import kg.vohkysan.home_work6_1.databinding.ActivityMainBinding
import kg.vohkysan.home_work6_1.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        with(binding) {
            homeViewModel.resultLive.observe(viewLifecycleOwner) {
                etWord.setText(homeViewModel.load())
            }
            btnDeleteAll.setOnClickListener {
                homeViewModel.delete()
            }
            btnNextFragment.setOnClickListener {
                if (etWord.text?.isEmpty() == true) {
                    Toast.makeText(context, "Edit text is empty", Toast.LENGTH_SHORT).show()
                } else {
                    val word = etWord.text.toString()
                    homeViewModel.save(word)
                    findNavController().navigate(R.id.navigation_result)
                }
            }
        }
    }
}