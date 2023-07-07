package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import dataDomain.SdButton
import dataDomain.SdLinkButton
import dataDomain.SdMainButton
import dataDomain.SdPrimaryButton

private const val RED = 0xFFFF0000
private const val BLUE = 0xFF0000FF
private const val FAQ_URL = "http://fairmoney.io/faq"

@Composable
internal fun ButtonView(
    button: SdButton,
    onClickAction: () -> Unit = {},
) {
    when (button) {
        is SdMainButton -> MainButton(button, onClickAction)
        is SdLinkButton -> MainButton(button, onClickAction)
        is SdPrimaryButton -> MainButton(button, onClickAction)
        else -> {}
    }
}

@Composable
private fun MainButton(button: SdButton, onClick: () -> Unit = {}) {
    FmTinyPrimaryButton(
        text = button.text,
        onClick = onClick,
        backgroundColor = button.style?.backgroundColor.toAndroidColor(),
        contentColor = button.style?.textColor.toAndroidColor(),
        border = BorderStroke(1.dp, button.style?.borderColor.toAndroidColor())
    )
}

/*@Composable
private fun PrimaryButton(button: SdButton, onClick: () -> Unit = {}) {
    FmPrimaryButton(
        text = button.text,
        onClick = onClick,
        backgroundColor = button.style?.backgroundColor.toAndroidColor(),
        contentColor = button.style?.textColor.toAndroidColor(),
        border = BorderStroke(1.dp, button.style?.borderColor.toAndroidColor())
    )
}

@Composable
private fun LinkButton(button: SdButton, onClick: () -> Unit = {}) {
    FmTextLinkButton(
        text = button.text,
        onClick = onClick,
        textColor = button.style?.textColor.toAndroidColor(),
        pressedTextColor = button.style?.textColor.toAndroidColor(),
        textStyle = FmTheme.typography.titleTiny,
        indication = rememberRipple(),
    )
}*/

