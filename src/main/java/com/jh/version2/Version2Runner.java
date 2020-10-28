package com.jh.version2;

import com.jh.version2.common.dto.variable.Role;
import com.jh.version2.domain.team.dto.TeamDto;
import com.jh.version2.domain.team.dto.TeamSaveDto;
import com.jh.version2.domain.user.dto.UserSaveDto;
import com.jh.version2.function.service.ApiTeamService;
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
    ApiTeamService teamService;

    @Autowired
    ApiUserService userService;

    @Override
    public void run(ApplicationArguments args) {
        final TeamDto teamA = teamService.postTeam(new TeamSaveDto("A-TEAM", 1500));
        final TeamDto teamB = teamService.postTeam(new TeamSaveDto("B-TEAM", 200));
        final TeamDto teamC = teamService.postTeam(new TeamSaveDto("C-TEAM", 500));
        final TeamDto teamD = teamService.postTeam(new TeamSaveDto("D-TEAM", 100));
        final TeamDto teamE = teamService.postTeam(new TeamSaveDto("E-TEAM", 2000));
        final TeamDto teamF = teamService.postTeam(new TeamSaveDto("F-TEAM", 12000));
        final TeamDto teamG = teamService.postTeam(new TeamSaveDto("G-TEAM", 9999));

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
        System.out.println("Team Count : " + teamService.getTeams().size());
        System.out.println("User Count : " + userService.getUsers().size());
        System.out.println("======================================================");
    }
}
