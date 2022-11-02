package soccer.utils;

import javax.persistence.Column;
import javax.persistence.Id;

public class LeagueStatisticsView {

	private long teamId;

	private String teamName;
	
	private int teamScore;
	
	private String idAsString;

	public long longId() {
		return this.teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return this.teamName;
	}
	
	public void setTeamName(String name) {
		this.teamName = name;
	}
	
	public int getTeamScore() {
		return this.teamScore;
	}

	public void setTeamScore(int teamScore) {
		this.teamScore = teamScore;
	}

	public String getIdAsString() {
		return this.idAsString;
	}
	
	public void setIdAsString() {
		this.idAsString = Long.toString(this.teamId);
	}
	
}
