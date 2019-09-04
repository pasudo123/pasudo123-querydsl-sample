package edu.pasudo123.querydsl.app.league.repository;

import edu.pasudo123.querydsl.app.league.model.League;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pasudo123 on 2019-09-05
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
public interface LeagueRepository extends JpaRepository<League, String> {
}
