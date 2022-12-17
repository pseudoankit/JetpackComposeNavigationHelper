package pseudoankit.droid.composenavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.squareup.moshi.Moshi
import pseudoankit.droid.composenavigation.JsonParser.decodeFromString
import pseudoankit.droid.composenavigation.JsonParser.encodeToString

object DetailScreenDestination : DestinationSpec {
    override val route: String = "details"
    override val navArgs: Array<NavArgs> = arrayOf(
        NavArgs("payload")
    )

    operator fun invoke(payload: DetailScreenPayload) =
        invoke(arrayOf(payload.encodeToString()))

    override val content: @Composable (navController: NavController, args: Array<out Any?>) -> Unit
        get() = { navController, args ->
            val payload =
                (args[0] as String).decodeFromString() ?: DetailScreenPayload()
            DetailScreen(payload)
        }

    @Composable
    private fun DetailScreen(payload: DetailScreenPayload) = Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Id : ${payload.id}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Name : ${payload.name}")
    }
}