package com.D121211084.mygames.presentation.search

import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.D121211084.mygames.base.BaseFragment
import com.D121211084.mygames.binding.viewBinding
import com.D121211084.mygames.utils.collectLifecycleFlow
import com.D121211084.mygames.utils.showToast
import com.D121211084.mygames.vo.Resource
import com.D121211084.mygames.R
import com.D121211084.mygames.data.source.remote.model.GamesResponse
import com.D121211084.mygames.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment(R.layout.fragment_search) {

    private val binding: FragmentSearchBinding by viewBinding()
    private val viewModel: SearchViewModel by viewModels()

    private val adapter: SearchGameAdapter by lazy {
        SearchGameAdapter {
            findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToGameDetailFragment(it.id ?: 0))
        }
    }

    override fun initUI() {
        super.initUI()
        with(binding) {
            rvGame.adapter = adapter
        }
    }

    override fun initAction() {
        super.initAction()
        with(binding) {
            etSearch.doOnTextChanged { text, _, _, _ ->
                viewModel.setSearchQuery(text.toString())
            }
        }
    }

    override fun initObserver() {
        super.initObserver()
        collectLifecycleFlow(viewModel.searchResult) {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Error -> {
                    showToast(it.message)
                }
                is Resource.Success -> {
                    onSearchGamesSuccess(it.data)
                }
            }
        }
    }

    private fun onSearchGamesSuccess(data: List<GamesResponse.Game>) {
        adapter.submitList(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvGame.adapter = null
    }

}