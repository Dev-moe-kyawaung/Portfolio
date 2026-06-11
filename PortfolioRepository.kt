class PortfolioRepository {
  private val database = PortfolioDatabase.getInstance()
  
  fun getProjects(): Flow<List<Project>> {
    return database.projectDao().getAllProjects()
  }
  
  fun getSkills(): Flow<List<Skill>> {
    return database.skillDao().getAllSkills()
  }
}
