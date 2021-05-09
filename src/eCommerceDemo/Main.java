package eCommerceDemo;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.core.logger.LoggerManagerAdapter;
import eCommerceDemo.core.verification.VerificationManagerAdapter;
import eCommerceDemo.dataAccess.concretes.GoogleUserDao;
import eCommerceDemo.entities.concretes.User;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserManager(new GoogleUserDao(), new LoggerManagerAdapter(), new VerificationManagerAdapter());

        User alper = new User(1, "Alper", "Aldemir", "alperaldemir0@gmail.com", "123456");
        User bugra = new User(2, "Bugra", "Aldemir", "alperaldemir0@gmail.com", "654321");
        User eren = new User(3, "Eren", "Aldemir", "erenaldemir0gmail.com", "enginHocamAdamsiniz<3");
        userService.add(alper);
        userService.add(bugra);

    }
}
