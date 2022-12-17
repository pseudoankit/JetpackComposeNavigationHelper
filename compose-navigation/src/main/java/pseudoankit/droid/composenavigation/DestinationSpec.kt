package pseudoankit.droid.composenavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import pseudoankit.droid.composenavigation.DestinationHelper.composableScreen

/**
 * contract to create a destination
 * apart from below methods create one method to be called while creating instance of destination with required param
 */
interface DestinationSpec {

    /**
     * route of the destination
     */
    val route: String

    /**
     * arguments specification which are expected while navigating to this destination @see[NavArgs]
     * */
    val navArgs: Array<NavArgs>

    /**
     * method to create route of the current destination
     * @param[param] arguments to be passed
     */
    operator fun invoke(param: Array<out Any?>) =
        NavigationHelper.BuildRoute(route, *param)

    /**
     * draw actual composable content for the destination
     * @param[navController] navController instance
     * @param[args] arguments passed by client while navigating to this destination
     */
    val content: @Composable (navController: NavController,args: Array<out Any?>) -> Unit

    /**
     * method to build compose destination
     * call this method to register you composable screen in NavHost
     */
    fun register(
        navGraphBuilder: NavGraphBuilder, navController: NavController
    ) = navGraphBuilder.composableScreen(route, *navArgs) {
        Box(modifier = Modifier.fillMaxSize()) {
            content(navController, it)
        }
    }
}