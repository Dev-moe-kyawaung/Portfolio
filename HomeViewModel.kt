class HomeViewModel : ViewModel() {
  private val repository = PortfolioRepository()
  
  private val _uiState = MutableStateFlow(HomeUiState())
  val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
  
  init {
    loadPortfolioData()
  }
  
  private fun loadPortfolioData() {
    viewModelScope.launch {
      val projects = repository.getProjects().first()
      val skills = repository.getSkills().first()
      _uiState.value = HomeUiState(projects = projects, skills = skills)
    }
  }
}
