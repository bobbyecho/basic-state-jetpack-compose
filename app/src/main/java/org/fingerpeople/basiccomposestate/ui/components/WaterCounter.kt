package org.fingerpeople.basiccomposestate.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.fingerpeople.basiccomposestate.ui.theme.BasicStateJetpackComposeTheme

@Composable
fun StatelessCounter(
	count: Int,
	onClick: () -> Unit,
	modifier: Modifier = Modifier
) {
	Column(modifier = modifier.padding(16.dp)) {
		if (count > 0) {
			Text(
				text = "You've had $count glasses.",
			)
		}
		Button(
			modifier = Modifier.padding(8.dp),
			onClick = onClick,
			enabled = count != 10
		) {
			Text("Add One")
		}
	}
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
	var count by remember { mutableStateOf(0) }

	StatelessCounter(count, { count ++ })
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
	BasicStateJetpackComposeTheme {
		WaterCounter()
	}
}