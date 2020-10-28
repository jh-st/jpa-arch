package com.jh.version2;

import com.jh.version2.common.dto.variable.Role;
import com.jh.version2.domain.team.dto.TeamDto;
import com.jh.version2.domain.team.dto.TeamSaveDto;
import com.jh.version2.domain.team.service.TeamService;
import com.jh.version2.domain.user.dto.UserSaveDto;
import com.jh.version2.function.service.ApiUserService;
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
    ApiUserService userService;

    @Override
    public void run(ApplicationArguments args) {
        final TeamDto teamA = teamService.save(new TeamSaveDto("A-TEAM", 1500));
        final TeamDto teamB = teamService.save(new TeamSaveDto("B-TEAM", 200));
        final TeamDto teamC = teamService.save(new TeamSaveDto("C-TEAM", 500));
        final TeamDto teamD = teamService.save(new TeamSaveDto("D-TEAM", 100));
        final TeamDto teamE = teamService.save(new TeamSaveDto("E-TEAM", 2000));

        for (int i=0; i<1000; i++) {
            if (i >= 800)
                userService.postUser(new UserSaveDto("test"+i, i, Role.ROLE_USER, teamE.getTeamId()));
            else if (i >= 600)
                userService.postUser(new UserSaveDto("test"+i, i, Role.ROLE_USER, teamD.getTeamId()));
            else if (i >= 400)
                userService.postUser(new UserSaveDto("test"+i, i, Role.ROLE_USER, teamC.getTeamId()));
            else if (i >= 200)
                userService.postUser(new UserSaveDto("test"+i, i, Role.ROLE_USER, teamB.getTeamId()));
            else
                userService.postUser(new UserSaveDto("test"+i, i, Role.ROLE_ADMIN, teamA.getTeamId()));
        }

        System.out.println("======================================================");
        System.out.println("User Count : " + userService.getUsers().size());
        System.out.println("======================================================");
    }
}
