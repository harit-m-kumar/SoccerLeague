package soccer.Repository;

import soccer.entity.SoccerTeams;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoccerTeamsRepository extends CrudRepository<SoccerTeams, Long> {
}