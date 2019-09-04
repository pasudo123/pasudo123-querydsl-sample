package edu.pasudo123.querydsl.app.team;

import edu.pasudo123.querydsl.app.league.League;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by pasudo123 on 2019-09-04
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@Getter
@Entity
@Table(name = "team",
        indexes = {
                @Index(name = "fk_team_league_idx", columnList = "league_name")
        })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(TeamPk.class)
public class Team {

    @Id
    @Column(name = "team_name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Id
    @ManyToOne(
            targetEntity = League.class,
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "league_name", columnDefinition = "VARCHAR(50)", referencedColumnName = "league_name")
    private League league;

    @Column(name = "team_desc", columnDefinition = "VARCHAR(200)", nullable = true)
    private String description;

    @Builder
    public Team(String name, League league, String description) {
        this.name = name;
        this.league = league;
        this.description = description;
    }

    public void changeDescription(String description) {
        this.description = description;
    }
}
