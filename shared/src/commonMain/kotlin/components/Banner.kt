package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/**
 * A simple banner that renders the given text
 *
 * @param text Text that should be rendered.
 */
@Composable
internal fun Banner(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)
        )
    }
}
