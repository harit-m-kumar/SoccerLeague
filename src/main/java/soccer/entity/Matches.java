package soccer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MATCHES")
public class Matches {
    @Id
    @Column(name="MATCH_ID")
    private long matchId;
    @Column(name="HOME_ID")
    private long homeId;
    @Column(name="AWAY_ID")
    private long awayId;
    @Column(name="HOME_SCORE")
    private int homeScore;
    @Column(name="AWAY_SCORE")
    private int awayScore;

    public long getMatchId() {
        return this.matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public long getHomeId() {
        return this.homeId;
    }

    public void setHomeId(long homeId) {
        this.homeId = homeId;
    }

    public int getHomeScore() {
        return this.homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }
    
    public long getAwayId() {
        return this.awayId;
    }

    public void setAwayId(long awayId) {
        this.awayId = awayId;
    }   
    
    public int getAwayScore() {
        return this.awayScore ;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }
    
    
    
}