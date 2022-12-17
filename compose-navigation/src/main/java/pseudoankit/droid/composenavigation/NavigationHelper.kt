package pseudoankit.droid.composenavigation

/**
 * Class containing logic to build route while navigating to a screen
 */
object NavigationHelper {

    object BuildRoute {

        /**
         * @param[route] actual route of destination
         * @param[param] params to be passed to the destination
         */
        operator fun invoke(route: String, vararg param: Any?): String = buildString {
            append(route)
            param.forEach {
                if (it == null) return@forEach
                append("/$it")
            }
        }
    }
}