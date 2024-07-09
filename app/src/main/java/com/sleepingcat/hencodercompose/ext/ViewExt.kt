import android.content.res.Resources
import android.util.TypedValue
import android.view.View

val Float.px
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)
val Int.px
    get() = this.toFloat().px

fun View.setVisibility(flag: Boolean) {
    visibility = if (flag) {
        View.VISIBLE
    } else {
        View.GONE
    }
}
