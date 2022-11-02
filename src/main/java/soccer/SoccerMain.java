package soccer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soccer.Repository.SoccerLeagueRepository;
import soccer.Repository.SoccerTeamsRepository;
import soccer.entity.SoccerLeague;
import soccer.entity.SoccerTeams;

@SpringBootApplication
@ComponentScan
public class SoccerMain {

	public static void main(String args[]) throws Exception {
		SpringApplication.run(SoccerMain.class, args);
	}

	@RestController
	@RequestMapping("/teams")
	public class TeamController {

		@Autowired(required=true)
		private SoccerTeamsRepository soccerTeamsRepository;

		@GetMapping
		public Iterable<SoccerTeams> getTeams() {
			return this.soccerTeamsRepository.findAll();
		}

	}
	
//	@RestController
//	@RequestMapping("/league")
//	public class SoccerLeagueWebController {
//
//		@Autowired
//		private SoccerLeagueRepository soccerLeagueRepository;
//		
//		@Autowired(required=true)
//		private SoccerTeamsRepository soccerTeamsRepository;
//		
//		@GetMapping("/statistics")
//		public Iterable<SoccerLeague> getLeagueStatisctics() {
//			return this.soccerLeagueRepository.findAll();
//		}
//		
//	}
}
