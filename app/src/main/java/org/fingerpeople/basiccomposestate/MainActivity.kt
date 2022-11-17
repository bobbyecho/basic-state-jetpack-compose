package org.fingerpeople.basiccomposestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import org.fingerpeople.basiccomposestate.ui.components.WaterCounter
import org.fingerpeople.basiccomposestate.ui.components.WellnessTaskList
import org.fingerpeople.basiccomposestate.ui.components.getWellnessTasks
import org.fingerpeople.basiccomposestate.ui.theme.BasicStateJetpackComposeTheme
import org.fingerpeople.basiccomposestate.viewmodel.WellnessViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    vm: WellnessViewModel = viewModel()
) {
   Column(modifier = modifier) {
       WaterCounter(modifier)

       WellnessTaskList(
           list = vm.tasks,
           onCloseTask = { vm.remove(it)},
           onCheckedTask = { task, checked ->
               vm.changeTaskChecked(task, checked)
           }
       )
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicStateJetpackComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            WellnessScreen()
        }
    }
}