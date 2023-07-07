package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FmTinyPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    iconResId: Int? = null,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    shape: Shape? = null,
    border: BorderStroke? = null,
) {
    val specifiedBackgroundColor =
        backgroundColor.default(Color(0xff1E1F26))
    val specifiedContentColor = contentColor.default(Color(0xffFFFFFF))

    Button(
        onClick = if (enabled && !loading) onClick else ({}),
        enabled = enabled,
        modifier = modifier.height(28.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = specifiedBackgroundColor,
            contentColor = specifiedContentColor,
            disabledContainerColor = Color(0xffc4c4c4),
            disabledContentColor = Color(0xffFFFFFF)
        ),
        contentPadding = PaddingValues(vertical = 0.dp, horizontal = 16.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            focusedElevation = 0.dp,
            hoveredElevation = 0.dp,
        ),
        shape = shape ?: MaterialTheme.shapes.small,
        border = border,
    ) {

        FmButtonText(
            text = text,
            textStyle = getTitleSmall(),
            color = specifiedContentColor,
        )
    }
}

@Composable
internal fun FmButtonText(text: String, textStyle: TextStyle, color: Color) {
    Text(
        text = text,
        style = textStyle,
        color = color,
        modifier = Modifier.testTag("button_text")
    )
}

fun getTitleSmall() = TextStyle.Default.copy(
    fontSize = 14.sp,
    lineHeight = 20.sp,
    fontWeight = FontWeight.Bold,
    color = Color(0xff1E1F26),
)

