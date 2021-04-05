package com.aiman.animatedrating.ui

import android.animation.ObjectAnimator
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.aiman.animatedrating.R
import com.aiman.animatedrating.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.ratingView.setRatingChangeListener { previousRating, newRating ->
            animateSmiley(previousRating, newRating)
            showRatingText(newRating)
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

    private fun showRatingText(rating: Int) {

        binding.ratingText.visibility = View.VISIBLE


        val ratingMessage = when(rating) {
            1 -> getString(R.string.text_rating_one)
            2 -> getString(R.string.text_rating_two)
            3 -> getString(R.string.text_rating_three)
            4 -> getString(R.string.text_rating_four)
            else -> getString(R.string.text_rating_five)
        }
        binding.ratingText.text = ratingMessage
    }

    private fun animateViewOffScreen() {
        ObjectAnimator.ofFloat(binding.tvHeading, "translationY", -400f).apply {
            duration = 400
            start()
        }

        ObjectAnimator.ofFloat(binding.ratingText, "translationY", -1600f).apply {
            duration = 600
            start()
        }

        ObjectAnimator.ofFloat(binding.ratingView, "translationY", -1800f).apply {
            duration = 600
            start()
        }

        ObjectAnimator.ofFloat(binding.submitBtn, "translationY", 1800f).apply {
            duration = 1000
            start()
        }

        MainScope().launch {
            delay(200)
            ObjectAnimator.ofFloat(binding.include.parent, "translationY", -620f).apply {
                duration = 800
                start()
            }

            delay(600)
            ObjectAnimator.ofFloat(binding.tvThanksForFeedback, "translationY", 350f).apply {
                duration = 300
                start()
            }

        }

    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.submit_btn -> {
                animateViewOffScreen()
            }
        }
    }
}