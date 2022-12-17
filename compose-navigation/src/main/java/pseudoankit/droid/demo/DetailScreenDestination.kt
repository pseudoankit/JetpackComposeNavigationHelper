package pseudoankit.droid.demo

/* check the implementation in app module
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
*/
