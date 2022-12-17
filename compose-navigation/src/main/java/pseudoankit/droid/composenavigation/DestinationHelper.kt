package pseudoankit.droid.composenavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

/**
 * class containing logic to build composable instance of any screen
 */
internal object DestinationHelper {

    /**
     * method responsible to create route and arguments
     * @param[route] route of the screen for which destination needs to be created
     * @param[content] content block to draw screen ui, invokes all params passed by client while calling the destination
     */
    fun NavGraphBuilder.composableScreen(
        route: String,
        vararg navArgs: NavArgs,
        content: @Composable (params: Array<Any?>) -> Unit
    ) = composable(
        route = BuildRoute(route = route, navArgs = navArgs),
        arguments = BuildArguments(navArgs = navArgs)
    ) { entry ->
        val arguments = navArgs.map { navArgs ->
            when (navArgs.type) {
                NavType.FloatType -> entry.arguments?.getFloat(navArgs.name) ?: navArgs.defaultValue
                NavType.FloatArrayType -> entry.arguments?.getFloatArray(navArgs.name)
                    ?: navArgs.defaultValue
                NavType.BoolType -> entry.arguments?.getBoolean(navArgs.name)
                    ?: navArgs.defaultValue
                NavType.BoolArrayType -> entry.arguments?.getByteArray(navArgs.name)
                    ?: navArgs.defaultValue
                NavType.IntType -> entry.arguments?.getInt(navArgs.name) ?: navArgs.defaultValue
                NavType.IntArrayType -> entry.arguments?.getIntArray(navArgs.name)
                    ?: navArgs.defaultValue
                NavType.StringType -> entry.arguments?.getString(navArgs.name)
                    ?: navArgs.defaultValue
                NavType.StringArrayType -> entry.arguments?.getStringArrayList(navArgs.name)
                    ?: navArgs.defaultValue
                else -> error("Params defined in destination seems mismatched for route: $route, param: ${navArgs.name}")
            }
        }.toTypedArray()
        content(arguments)
    }

    private object BuildRoute {

        /**
         * helper method to build destination route
         */
        operator fun invoke(route: String, vararg navArgs: NavArgs) = buildString {
            append(route)
            navArgs.forEach {
                append("/{${it.name}}")
            }
        }
    }

    private object BuildArguments {

        /**
         * helper method to build arguments list for composable
         */
        operator fun invoke(vararg navArgs: NavArgs) = navArgs.map {
            navArgument(it.name) {
                type = it.type
                nullable = it.nullable
                defaultValue = it.defaultValue
            }
        }
    }
}