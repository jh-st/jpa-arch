package com.jh.version2;

import com.jh.version2.service.team.TeamService;
import com.jh.version2.service.team.dto.TeamDto;
import com.jh.version2.service.team.dto.TeamSaveDto;
import com.jh.version2.service.user.UserService;
import com.jh.version2.service.user.dto.UserSaveDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class Version2Runner implements ApplicationRunner {

    @Autowired
    TeamService teamService;

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final TeamDto teamA = teamService.save(new TeamSaveDto("A팀", 1500));
        final TeamDto teamB = teamService.save(new TeamSaveDto("B팀", 200));
        final TeamDto teamC = teamService.save(new TeamSaveDto("C팀", 500));
        final TeamDto teamD = teamService.save(new TeamSaveDto("D팀", 100));
        final TeamDto teamE = teamService.save(new TeamSaveDto("E팀", 2000));

        for (int i=0; i<1000; i++) {
            if (i >= 800)
                userService.save(new UserSaveDto("test"+i, i, teamE.getTeamId()));
            else if (i >= 600)
                userService.save(new UserSaveDto("test"+i, i, teamD.getTeamId()));
            else if (i >= 400)
                userService.save(new UserSaveDto("test"+i, i, teamC.getTeamId()));
            else if (i >= 200)
                userService.save(new UserSaveDto("test"+i, i, teamB.getTeamId()));
            else
                userService.save(new UserSaveDto("test"+i, i, teamA.getTeamId()));
        }

        System.out.println("======================================================");
        System.out.println("User Count : " + userService.findAll().size());
        System.out.println("======================================================");
    }
}
