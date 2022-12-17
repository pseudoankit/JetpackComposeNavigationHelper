package pseudoankit.droid.demo

/* check the implementation in app module
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
                    id = Random().nextInt(),
                    name = "I have been sent from listings"
                )
            )
        }) {
            Text(text = "Navigate To Detail")
        }
    }
}
*/
