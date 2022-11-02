package soccer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOCCER_TEAMS")
public class SoccerTeams {
	@Id
	@Column(name = "TEAM_ID")
	private long teamId;
	@Column(name = "TEAM_NAME")
	private String teamName;

	public long getId() {
		return this.teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
