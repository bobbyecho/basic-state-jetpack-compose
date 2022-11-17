package org.fingerpeople.basiccomposestate.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.fingerpeople.basiccomposestate.data.WellnessTask

fun getWellnessTasks() = List(30) {
	WellnessTask(it, "Task # $it")
}

@Composable
fun WellnessTaskList(
	modifier: Modifier = Modifier,
	onCloseTask: (WellnessTask) -> Unit,
	onCheckedTask: (task: WellnessTask, checked: Boolean) -> Unit,
	list: List<WellnessTask>
) {
	LazyColumn(
		modifier = modifier,
	) {
		items(
			list,
			key = { task -> task.id }
		) {
			WellnessTaskItem(
				taskName = it.label,
				checked = it.checked,
				onClose = {
					onCloseTask(it)
				},
				onCheckedChange = { checked ->
					onCheckedTask(it, checked)
				}
			)
		}
	}
}
