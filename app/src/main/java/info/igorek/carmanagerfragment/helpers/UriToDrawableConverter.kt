package info.igorek.carmanagerfragment.helpers

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.core.content.ContextCompat
import info.igorek.carmanagerfragment.R

object UriToDrawableConverter {
    fun uriToDrawable(uri: String?, context: Context) : Drawable? {
        uri?.let {
            val inputStream = context.contentResolver.openInputStream(Uri.parse(uri))
            return Drawable.createFromStream(inputStream, uri)
        }
        return ContextCompat.getDrawable(context, R.drawable.empty_car)
    }
}