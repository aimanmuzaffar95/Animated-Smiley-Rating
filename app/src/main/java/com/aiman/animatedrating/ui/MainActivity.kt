package com.aiman.animatedrating.ui

import android.content.Intent
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.aiman.animatedrating.R
import com.aiman.animatedrating.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.ratingView.setRatingChangeListener { previousRating, newRating ->
            animateSmiley(previousRating, newRating)
        }

    }

    private fun animateSmiley(previousRating: Int, newRating: Int) {
        val animation = getRateAnimation(previousRating, newRating)
        animation?.let {
            val animatedVector = ContextCompat.getDrawable(this@MainActivity, it)
            binding.include.mouth.setImageDrawable(animatedVector)
            (animatedVector as AnimatedVectorDrawable).start()
        }
    }

    private fun getRateAnimation(previousRating: Int, newRating: Int) = when {

        0 == previousRating && 1 == newRating -> R.drawable.anim_zero_to_one
        0 == previousRating && 2 == newRating -> R.drawable.anim_zero_to_two
        0 == previousRating && 3 == newRating -> R.drawable.anim_zero_to_three
        0 == previousRating && 4 == newRating -> R.drawable.anim_zero_to_four
        0 == previousRating && 5 == newRating -> R.drawable.anim_zero_to_five

        1 == previousRating && 2 == newRating -> R.drawable.anim_one_to_two
        1 == previousRating && 3 == newRating -> R.drawable.anim_one_to_three
        1 == previousRating && 4 == newRating -> R.drawable.anim_one_to_four
        1 == previousRating && 5 == newRating -> R.drawable.anim_one_to_five

        2 == previousRating && 1 == newRating -> R.drawable.anim_two_to_one
        2 == previousRating && 3 == newRating -> R.drawable.anim_two_to_three
        2 == previousRating && 4 == newRating -> R.drawable.anim_two_to_four
        2 == previousRating && 5 == newRating -> R.drawable.anim_two_to_five

        3 == previousRating && 1 == newRating -> R.drawable.anim_three_to_one
        3 == previousRating && 2 == newRating -> R.drawable.anim_three_to_two
        3 == previousRating && 4 == newRating -> R.drawable.anim_three_to_four
        3 == previousRating && 5 == newRating -> R.drawable.anim_three_to_five

        4 == previousRating && 1 == newRating -> R.drawable.anim_four_to_one
        4 == previousRating && 2 == newRating -> R.drawable.anim_four_to_two
        4 == previousRating && 3 == newRating -> R.drawable.anim_four_to_three
        4 == previousRating && 5 == newRating -> R.drawable.anim_four_to_five

        5 == previousRating && 1 == newRating -> R.drawable.anim_five_to_one
        5 == previousRating && 2 == newRating -> R.drawable.anim_five_to_two
        5 == previousRating && 3 == newRating -> R.drawable.anim_five_to_three
        5 == previousRating && 4 == newRating -> R.drawable.anim_five_to_four

        else -> null
    }
}