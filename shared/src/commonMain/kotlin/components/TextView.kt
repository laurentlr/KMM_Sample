package components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import dataDomain.SdText

@Composable
internal fun SdTextView(
    sdText: SdText,
    modifier: Modifier,
    style: TextStyle,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        text = sdText.text,
        modifier = modifier,
        style = sdText.sdStyle?.let { style.copy(color = it.textColor.toAndroidColor()) } ?: style,
        textAlign = textAlign,
    )
}

