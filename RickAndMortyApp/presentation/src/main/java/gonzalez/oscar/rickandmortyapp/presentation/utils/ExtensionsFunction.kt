package gonzalez.oscar.rickandmortyapp.presentation.utils

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import gonzalez.oscar.rickandmortyapp.R

fun ImageView.loadImage(
    url: String,
    defaultImage: Drawable = ContextCompat.getDrawable(context, R.drawable.ic_person)!!
) {
    Picasso.get().load(url).placeholder(defaultImage).into(this)
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun Fragment.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, text, duration).show()
}

fun Fragment.navigate(navigation: NavDirections) {
    try {
        findNavController().navigate(navigation)
    } catch (exception: Exception) {
        Log.e("Nav:", exception.toString())
    }
}