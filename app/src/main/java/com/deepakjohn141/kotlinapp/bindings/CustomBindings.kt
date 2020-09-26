package com.deepakjohn141.kotlinapp.bindings

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
object CustomBindings {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun imageBinding(imageView: ImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(imageView.context)
                .load(imageUrl)
                .listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        imageView.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        imageView.visibility = View.VISIBLE
                        return false
                    }

                })
                .into(imageView)
        } else imageView.visibility = View.GONE
    }
}