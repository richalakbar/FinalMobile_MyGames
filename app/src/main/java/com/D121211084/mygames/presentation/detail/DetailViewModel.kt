package com.D121211084.mygames.presentation.detail

import androidx.lifecycle.ViewModel
import com.D121211084.mygames.data.source.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: GamesRepository) : ViewModel() {

    fun getGameDetails(id: Long) = repository.getGameDetails(id)


}