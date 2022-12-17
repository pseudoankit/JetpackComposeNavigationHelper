package pseudoankit.droid.demo

import android.os.Parcelable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.parcelize.Parcelize
import pseudoankit.droid.composenavigation.DestinationSpec
import pseudoankit.droid.composenavigation.JsonParser.decodeFromString
import pseudoankit.droid.composenavigation.JsonParser.encodeToString
import pseudoankit.droid.composenavigation.NavArgs

@Parcelize
data class Payload(val id: Int = 0): Parcelable

object DetailScreenDestination : DestinationSpec {
    override val route: String = "details"
    override val navArgs: Array<NavArgs> = arrayOf(
        NavArgs("payload")
    )

    operator fun invoke(payload: Payload) =
        invoke(kotlin.arrayOf(payload.encodeToString()))

    override val content: @Composable (navController: NavController, args: Array<out Any?>) -> Unit
        get() = { navController, args ->
            val payload =
                (args[0] as String).decodeFromString() ?: Payload()
            DetailScreen(payload)
        }

    @Composable
    private fun DetailScreen(payload: Payload) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Id : ${payload.id}")
        }
    }
}
