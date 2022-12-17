package pseudoankit.droid.demo

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import pseudoankit.droid.composenavigation.DestinationSpec
import pseudoankit.droid.composenavigation.NavArgs

object ListingScreenDestination : DestinationSpec {

    override val route: String
        get() = "listing"

    // not expecting any parameter so empty array
    override val navArgs: Array<NavArgs>
        get() = arrayOf()

    operator fun invoke() = invoke(arrayOf())

    override val content: @Composable (navController: NavController, args: Array<out Any?>) -> Unit
        get() = { navController, args ->
            ListingScreen(navController)
        }

    @Composable
    private fun ListingScreen(navController: NavController) {
        Button(onClick = {
            navController.navigate(
                DetailScreenDestination(
                    Payload(100)
                )
            )
        }) {
            Text(text = "Navigate To Detail")
        }
    }
}
