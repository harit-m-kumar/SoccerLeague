package soccer.webController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soccer.Repository.MatchesRepository;
import soccer.Repository.SoccerLeagueRepository;
import soccer.Repository.SoccerTeamsRepository;
import soccer.entity.Matches;
import soccer.entity.SoccerLeague;
import soccer.entity.SoccerTeams;
import soccer.utils.LeagueStatisticsView;

@RestController
@RequestMapping("/league")
public class SoccerLeagueWebController {

	@Autowired
	private SoccerLeagueRepository soccerLeagueRepository;
	
	@Autowired
	private SoccerTeamsRepository soccerTeamsRepository;
	
	@Autowired
	private MatchesRepository matchesRepository;
	
	@GetMapping("/statistics")
	public Iterable<LeagueStatisticsView> getLeagueStatisctics() {
		Iterable<SoccerLeague> soccerLeagueScores = this.soccerLeagueRepository.findAll();
		List<LeagueStatisticsView> leagueStatisticsView = new ArrayList<LeagueStatisticsView>();
		for (SoccerLeague teamInstance : soccerLeagueScores) {
			LeagueStatisticsView leagueStatisticsViewInstance = new LeagueStatisticsView();
			leagueStatisticsViewInstance.setTeamId(teamInstance.getId());
			leagueStatisticsViewInstance.setTeamScore(teamInstance.getTeamScore());
			Optional<SoccerTeams> soccerTeam = this.soccerTeamsRepository.findById(teamInstance.getId());
			leagueStatisticsViewInstance.setTeamName(soccerTeam.get().getTeamName());
			leagueStatisticsViewInstance.setIdAsString();
			//leagueStatisticsViewInstance.setTeamName("asd");
			leagueStatisticsView.add(leagueStatisticsViewInstance);
		}
		return leagueStatisticsView;
	}
	
	@GetMapping("/teams")
	public Iterable<SoccerTeams> getTeamsList() {
		Iterable<SoccerTeams> soccerTeams = this.soccerTeamsRepository.findAll();
		return soccerTeams;
	}
	
	@GetMapping("/addTeam/{id}/{teamName}")
	public ResponseEntity<SoccerTeams> addTeam(@PathVariable String id, @PathVariable String teamName) {
		SoccerTeams soccerTeam = new SoccerTeams();
		soccerTeam.setTeamId(Long.valueOf(id));
		soccerTeam.setTeamName(teamName);
		this.soccerTeamsRepository.save(soccerTeam);
		return ResponseEntity.ok(soccerTeam);
	}
	
	@GetMapping("addMatch/{matchId}/{homeId}/{homeScore}/{awayId}/{awayScore}")
	public ResponseEntity<Matches> addMatch (@PathVariable String matchId, @PathVariable String homeId, @PathVariable String homeScore
			, @PathVariable String awayId, @PathVariable String awayScore) {
		Matches match = new Matches();
		match.setMatchId(Long.valueOf(matchId));
		match.setHomeId(Long.valueOf(homeId));
		match.setHomeScore(Integer.valueOf(homeScore));
		match.setAwayId(Long.valueOf(awayId));
		match.setAwayScore(Integer.valueOf(awayScore));
		matchesRepository.save(match);
		return ResponseEntity.ok(match);
	}
	
//	@PostMapping(value = "/addTeam")
//	public ResponseEntity<SoccerTeams> addTeam(@RequestBody SoccerTeams newTeam) {
//		this.soccerTeamsRepository.save(newTeam);
//		return ResponseEntity.ok(newTeam);
//	}
	
}
//java -jar soccer-0.0.1-SNAPSHOT.jar
//java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=4000,suspend=n -jar soccer-0.0.1-SNAPSHOT.jar
