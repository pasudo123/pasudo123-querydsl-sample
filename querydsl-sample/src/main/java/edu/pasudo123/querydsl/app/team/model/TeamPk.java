package edu.pasudo123.querydsl.app.team.model;

import edu.pasudo123.querydsl.app.league.model.LeaguePk;
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

    private LeaguePk league;

    private Long id;

    private String name;

}
