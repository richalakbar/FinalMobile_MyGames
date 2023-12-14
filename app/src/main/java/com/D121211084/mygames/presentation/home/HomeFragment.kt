package com.D121211084.mygames.presentation.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kennyc.view.MultiStateView
import com.D121211084.mygames.base.BaseFragment
import com.D121211084.mygames.binding.viewBinding
import com.D121211084.mygames.utils.collectLifecycleFlow
import com.D121211084.mygames.utils.showToast
import com.D121211084.mygames.vo.Resource
import com.D121211084.mygames.R
import com.D121211084.mygames.databinding.FragmentHomeBinding
import com.D121211084.mygames.presentation.home.adapter.GameAdapter

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()
    private val viewModel: HomeViewModel by viewModels()

    private val adapter: GameAdapter by lazy {
        GameAdapter {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToGameDetailFragment(it.id ?: 0))
        }
    }

    override fun initObserver() {
        super.initObserver()
        with(binding) {
            collectLifecycleFlow(viewModel.games) {
                when (it) {
                    is Resource.Loading -> {
                        msvGame.viewState = MultiStateView.ViewState.LOADING
                    }
                    is Resource.Error -> {
                        msvGame.viewState = MultiStateView.ViewState.CONTENT
                        showToast(it.message)
                    }
                    is Resource.Success -> {
                        msvGame.viewState = MultiStateView.ViewState.CONTENT
                        val recyclerViewState = rvGame.layoutManager?.onSaveInstanceState()
                        adapter.submitList(it.data)
                        rvGame.layoutManager?.onRestoreInstanceState(recyclerViewState)
                    }
                }
            }
        }
    }

    override fun initUI() {
        super.initUI()
        with(binding) {
            rvGame.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvGame.adapter = null
    }

}