package edu.pasudo123.querydsl.app.member;

import edu.pasudo123.querydsl.app.team.Team;
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
@Table(name = "member",
        indexes = {
                @Index(name = "fk_member_team_idx", columnList = "league_name, team_name")
        })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(MemberPk.class)
public class Member {

    @Id
    @ManyToOne(
            targetEntity = Team.class,
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumns({
            @JoinColumn(name = "league_name", columnDefinition = "VARCHAR(50)", referencedColumnName = "league_name"),
            @JoinColumn(name = "team_name", columnDefinition = "VARCHAR(50)", referencedColumnName = "team_name")
    })
    private Team team;

    @Id
    @Column(name = "member_name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;


    @Column(name = "member_desc", columnDefinition = "VARCHAR(200)", nullable = true)
    private String description;

    @Builder
    public Member(String name, Team team, String description) {
        this.name = name;
        this.team = team;
        this.description = description;
    }

    public void changeDescription(String description) {
        this.description = description;
    }
}
