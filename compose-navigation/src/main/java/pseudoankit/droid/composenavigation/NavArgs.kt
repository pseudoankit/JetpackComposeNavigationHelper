package pseudoankit.droid.composenavigation

import androidx.navigation.NavType

/**
 * specs to created destination route
 * @param[name] route name
 * @param[type] type of argument eg: String, Int, etc...
 * @param[nullable] is value support nullable
 * @param[defaultValue] default value is incoming value is null
 */
data class NavArgs(
    val name: String,
    val type: NavType<*>,
    val nullable: Boolean,
    val defaultValue: Any?,
) {
    constructor(name: String) : this(name, NavType.StringType, true, "")
}