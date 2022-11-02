package soccer.Repository;

import soccer.entity.SoccerLeague;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoccerLeagueRepository extends CrudRepository<SoccerLeague, Long> {
}

