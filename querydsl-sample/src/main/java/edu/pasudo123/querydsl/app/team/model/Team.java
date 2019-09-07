package edu.pasudo123.querydsl.app.team.model;

import edu.pasudo123.querydsl.app.league.model.League;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

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
@EntityListeners(AuditingEntityListener.class)
public class Team {

    @Id
    @ManyToOne(
            targetEntity = League.class,
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumns({
        @JoinColumn(name = "league_id", columnDefinition = "INT", referencedColumnName = "id"),
        @JoinColumn(name = "league_name", columnDefinition = "VARCHAR(50)", referencedColumnName = "league_name")
    })
    private League league;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column(name = "team_name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "team_desc", columnDefinition = "VARCHAR(200)", nullable = true)
    private String description;

    @CreatedDate
    @Column(name = "reg_date", columnDefinition = "DATETIME", nullable = false, updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "mod_date", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime modDate;

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
