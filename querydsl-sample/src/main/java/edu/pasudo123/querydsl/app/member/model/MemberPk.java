package edu.pasudo123.querydsl.app.member.model;

import edu.pasudo123.querydsl.app.team.model.Team;
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
public class MemberPk implements Serializable {

    private Team team;

    private String name;

}
