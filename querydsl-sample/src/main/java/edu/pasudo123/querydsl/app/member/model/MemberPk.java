package edu.pasudo123.querydsl.app.member.model;

import edu.pasudo123.querydsl.app.team.model.TeamPk;
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

    private TeamPk team;

    private String memberUid;

    private String name;

}
