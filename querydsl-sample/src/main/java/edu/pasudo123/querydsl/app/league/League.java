package edu.pasudo123.querydsl.app.league;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by pasudo123 on 2019-09-04
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@Getter
@Entity
@Table(name = "league")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class League {

    @Id
    @Column(name = "league_name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "league_desc", columnDefinition = "VARCHAR(200)", nullable = true)
    private String desc;

    @Builder
    public League(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
}
