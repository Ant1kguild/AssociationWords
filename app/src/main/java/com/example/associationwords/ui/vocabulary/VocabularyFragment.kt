package com.example.associationwords.ui.vocabulary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.associationwords.R
import com.example.associationwords.databinding.FragmentMyVocabularyBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class VocabularyFragment : Fragment() {

    private lateinit var binding: FragmentMyVocabularyBinding
    private var adapter = VocabularyRVAdapter(VocabularyRVAdapter.testData)
    private val vocabularyViewModel: VocabularyViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_my_vocabulary, container, false)
        binding.rvVocabulary.adapter = adapter
        return binding.root
    }
}
