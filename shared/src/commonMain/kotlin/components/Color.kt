package components

import androidx.compose.ui.graphics.Color

fun Color?.default(defaultColor: Color): Color {
    return if (this == null || this == Color.Unspecified)
        defaultColor
    else this
}
