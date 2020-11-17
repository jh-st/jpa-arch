package com.jh.version2;

import com.jh.version2.domain.book.Book;
import com.jh.version2.domain.store.Store;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@NoArgsConstructor
public class Version2Runner implements ApplicationRunner {

    /*@Autowired
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
        final TeamDto teamH = teamService.postTeam(new TeamSaveDto("H-TEAM", 19999, teamG.getTeamId()));
        final TeamDto teamI = teamService.postTeam(new TeamSaveDto("I-TEAM", 29999, teamG.getTeamId()));

        for (int i=0; i<1000; i++) {
            if (i >= 800)
                userService.postUser(new UserSaveDto("test"+i, i, Role.ROLE_USER, Level.HIGH, teamE.getTeamId()));
            else if (i >= 600)
                userService.postUser(new UserSaveDto("test"+i, i, Role.ROLE_USER, Level.MEDIUM, teamD.getTeamId()));
            else if (i >= 400)
                userService.postUser(new UserSaveDto("test"+i, i, Role.ROLE_USER, Level.LOW, teamC.getTeamId()));
            else if (i >= 200)
                userService.postUser(new UserSaveDto("test"+i, i, Role.ROLE_USER, Level.HIGH, teamB.getTeamId()));
            else
                userService.postUser(new UserSaveDto("test"+i, i, Role.ROLE_ADMIN, Level.LOW, teamA.getTeamId()));
        }

        System.out.println("======================================================");
        System.out.println("Team Count : " + teamService.getTeams().size());
        System.out.println("User Count : " + userService.getUsers().size());
        System.out.println("======================================================");


    }*/

    @Autowired
    EntityManager entityManager;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Store store = new Store();
        store.setName("store1");
        entityManager.persist(store);

        Store store2 = new Store();
        store2.setName("store2");
        entityManager.persist(store2);

        Store store3 = new Store();
        store3.setName("store3");
        entityManager.persist(store3);

        Store store4 = new Store();
        store4.setName("store4");
        entityManager.persist(store4);

        Store store5 = new Store();
        store5.setName("store5");
        entityManager.persist(store5);

        Book book = new Book();
        book.setName("book1");
        book.setPrice(1000);
        book.setStore(store);
        entityManager.persist(book);

        Book book1 = new Book();
        book1.setName("book1");
        book1.setPrice(1000);
        book1.setStore(store);
        entityManager.persist(book1);

        Book book2 = new Book();
        book2.setName("book1");
        book2.setPrice(1000);
        book2.setStore(store);
        entityManager.persist(book2);

        entityManager.flush();
        entityManager.clear();
    }

    /*@Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamRepository teamRepository;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Team teamSave = teamRepository.save(Team.builder().name("team1").score(100).build());

        entityManager.flush();
        entityManager.clear();

        User userSave = userRepository.save(User.builder()
                .name("test")
                .age(1)
                .role(Role.ROLE_ADMIN)
                .level(Level.HIGH)
                .team(teamSave)
                .build());

        entityManager.flush();
        entityManager.clear();

    }*/
}
