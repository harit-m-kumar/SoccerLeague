package soccer.Repository;

import soccer.entity.Matches;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchesRepository extends CrudRepository<Matches, Long> {
}