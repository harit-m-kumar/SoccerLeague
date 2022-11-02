package soccer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOCCER_LEAGUE")
public class SoccerLeague {
	@Id
	@Column(name = "TEAM_ID")
	private long teamId;
	@Column(name = "TEAM_SCORE")
	private int teamScore;

	public long getId() {
		return this.teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public int getTeamScore() {
		return this.teamScore;
	}

	public void setTeamScore(int teamScore) {
		this.teamScore = teamScore;
	}

}