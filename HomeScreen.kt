@Composable
fun HomeScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
      .padding(24.dp)
  ) {
    HeroSection()
    StatsCounter()
    SkillsSection()
    ProjectList()
    ContactButton()
  }
}
