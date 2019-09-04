package edu.pasudo123.querydsl.app.team;

import edu.pasudo123.querydsl.app.league.League;
import lombok.*;

import java.io.Serializable;

/**
 * Created by pasudo123 on 2019-09-04
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TeamPk implements Serializable {

    private String name;

    private League league;

}
