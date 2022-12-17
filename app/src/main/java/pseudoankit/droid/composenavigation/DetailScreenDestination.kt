package pseudoankit.droid.composenavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType

object DetailScreenDestination : DestinationSpec {
    override val route: String = "details"
    override val navArgs: Array<NavArgs> = arrayOf(
        NavArgs("id", type = NavType.IntType, nullable = false, defaultValue = 2),
        NavArgs("name")
    )

    operator fun invoke(id: Int, name: String) = invoke(arrayOf(id, name))

    override val content: @Composable (navController: NavController, args: Array<out Any?>) -> Unit
        get() = { navController, args ->
            DetailScreen(args[0] as Int, args[1] as String)
        }

    @Composable
    private fun DetailScreen(id: Int, name: String) = Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Id : $id")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Name : $name")
    }
}