package com.d121211069.submissionandroidexpert.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.d121211069.submissionandroidexpert.R
import com.d121211069.submissionandroidexpert.core.domain.model.Film
import com.d121211069.submissionandroidexpert.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        @Suppress("DEPRECATION")
        val data = intent.getParcelableExtra<Film>(DATA)

        if (data != null) {
            binding.filmTitle.text = data.title
            binding.filmVote.text = getString(R.string.vote_average, data.vote)
            binding.filmReleaseDate.text = getString(R.string.release_date, data.releaseDate)
            Glide.with(this).load("https://image.tmdb.org/t/p/w500/${data.image}")
                .into(binding.filmImage)
            binding.descriptionText.text = data.overview
        }

        binding.arrowBack.setOnClickListener {
            onBackPressed()
        }

        var statusFavorite = data?.isFavorite as Boolean
        setStatusFavorite(statusFavorite, false)
        binding.fabFav.setOnClickListener {
            statusFavorite = !statusFavorite
            detailViewModel.setFavoriteFilm(data, statusFavorite)
            setStatusFavorite(statusFavorite, true)
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean, onClick: Boolean) {
        if (statusFavorite) {
            binding.fabFav.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.baseline_favorite_24
                )
            )
            if (onClick) Toast.makeText(this, "Successfully added favorite", Toast.LENGTH_SHORT)
                .show()
        } else {
            binding.fabFav.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.baseline_favorite_border_24
                )
            )
            if (onClick) Toast.makeText(this, "Successfully removed favorite", Toast.LENGTH_SHORT)
                .show()
        }
    }

    companion object {
        private const val DATA = "data_detail"
    }

}