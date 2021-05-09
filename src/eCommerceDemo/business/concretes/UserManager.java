package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.logger.LoggerService;
import eCommerceDemo.core.verification.VerificationService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {

    private UserDao userDao;
    private LoggerService loggerService;
    private VerificationService verificationService;

    public UserManager(UserDao userDao, LoggerService emailLoggerService, VerificationService verificationService) {
        this.userDao = userDao;
        this.loggerService = emailLoggerService;
        this.verificationService = verificationService;
    }

    private boolean checkEmail(User user) {
        Pattern regExPattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher match = regExPattern.matcher(user.geteMail());
        boolean matched = match.matches();
        if (matched==true){
            System.out.println("Email adresi gecerli.");
            return true;
        }else {
            System.out.println("Email adresi gecersiz.");
            return false;
        }
    }

    private boolean checkNameSurnameLength(User user) {
        if(user.getFirstName().length()<2 || user.getLastName().length()<2) {
            System.out.println("Adınız ve Soyadınız en az iki karakterden oluşmalıdır.");
            return false;
        }else
            return true;
    }

    private boolean checkPassword(User user) {
        if(user.getPassword().length()<6) {
            System.out.println("Parola en az 6 karakterden oluşmalıdır.");
            return false;
        }else {
            return true;
        }
    }

    private void sendVerification() {
        System.out.println("Doğrulama e-postası gönderilmiştir.");
    }

    @Override
    public void add(User user) {
        boolean okPassword = checkPassword(user);
        boolean okMail = checkEmail(user);
        boolean okNameSurname = checkNameSurnameLength(user);

        if (okPassword == true && okMail == true && okNameSurname == true){
            System.out.println("Kayit Basarili. Hosgeldin: " + user.getFirstName());
            sendVerification();
        }else{
            System.out.println("Kayit Basarisiz.");
        }
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
