package ru.webservice.calories;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.webservice.calories.model.Role;
import ru.webservice.calories.model.User;
import ru.webservice.calories.repository.UserRepository;
import ru.webservice.calories.service.UserService;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

//        UserRepository userRepository = (UserRepository) appCtx.getBean("mockUserRepository");
        UserRepository userRepository = appCtx.getBean(UserRepository.class);
        userRepository.getAll();

        UserService userService = appCtx.getBean(UserService.class);
        userService.create(new User(null, "userName", "email@mail.ru", "password", Role.ROLE_ADMIN));

        appCtx.close();
    }
}
