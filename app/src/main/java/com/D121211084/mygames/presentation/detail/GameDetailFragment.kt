package com.D121211084.mygames.presentation.detail

import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.D121211084.mygames.R
import com.D121211084.mygames.base.BaseFragment
import com.D121211084.mygames.binding.viewBinding
import com.D121211084.mygames.data.source.remote.model.GameDetailsResponse
import com.D121211084.mygames.databinding.FragmentGameDetailBinding
import com.D121211084.mygames.utils.ConverterDate
import com.D121211084.mygames.utils.collectLifecycleFlow
import com.D121211084.mygames.utils.convertDateTo
import com.D121211084.mygames.utils.loadImage
import com.D121211084.mygames.utils.showToast
import com.D121211084.mygames.vo.Resource

class GameDetailFragment : BaseFragment(R.layout.fragment_game_detail) {

    private val binding: FragmentGameDetailBinding by viewBinding()
    private val viewModel: DetailViewModel by viewModels()
    private val args: GameDetailFragmentArgs by navArgs()

    override fun initUI() {
        super.initUI()
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(binding.toolbar)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun initObserver() {
        super.initObserver()
        collectLifecycleFlow(viewModel.getGameDetails(args.id)) {
            when (it) {
                is Resource.Loading -> {
                }

                is Resource.Error -> {
                    showToast(it.message)
                }

                is Resource.Success -> {
                    showGameDetails(it.data)
                }
            }
        }
    }

    private fun showGameDetails(game: GameDetailsResponse) {
        with(binding) {
            toolbar.title = game.name
            tvTitle.text = game.name
            tvReleaseDate.text =
                "Released: ${game.released?.convertDateTo(ConverterDate.FULL_DATE)}"
            tvRating.text = "${game.rating}/5"
            tvDescription.text = Html.fromHtml(game.description, Html.FROM_HTML_MODE_COMPACT)
            ivGame.loadImage(game.backgroundImage.orEmpty())
            tvGenre.text = game.genres?.joinToString { it?.name.orEmpty() }
        }
    }

}