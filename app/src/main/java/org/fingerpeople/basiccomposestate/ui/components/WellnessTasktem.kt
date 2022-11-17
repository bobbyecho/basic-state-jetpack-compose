package org.fingerpeople.basiccomposestate.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.fingerpeople.basiccomposestate.ui.theme.BasicStateJetpackComposeTheme

@Composable
fun WellnessTaskItem(
	modifier: Modifier = Modifier,
	taskName: String,
	checked: Boolean,
	onCheckedChange: (Boolean) -> Unit,
	onClose: () -> Unit
) {
	Row(
		modifier = modifier,
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			modifier = Modifier
				.weight(1F)
				.padding(start = 16.dp),
			text = taskName
		)
		Checkbox(
			checked = checked,
			onCheckedChange = onCheckedChange
		)
		IconButton(onClick = onClose) {
			Icon(Icons.Filled.Close, contentDescription = "Close")
		}
	}
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
	BasicStateJetpackComposeTheme {
		WellnessTaskItem(
			taskName = "Go eat now!",
			onClose = {},
			checked = true,
			onCheckedChange = {}
		)
	}
}