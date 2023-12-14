package com.D121211084.mygames.presentation.home

import androidx.lifecycle.ViewModel
import com.D121211084.mygames.data.source.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: GamesRepository) : ViewModel() {

    val games = repository.getAllGames()

}