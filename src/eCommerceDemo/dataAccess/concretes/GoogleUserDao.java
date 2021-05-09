package eCommerceDemo.dataAccess.concretes;

import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

import java.util.List;

public class GoogleUserDao implements UserDao {
    @Override
    public void add(User user) {
        System.out.println("Google kullanicisi kayit oldu. Kullanici veritabanina eklendi: " + user.getFirstName());
    }

    @Override
    public void update(User user) {
        System.out.println("Google kullanicisi guncellendi: " + user.getFirstName());
    }

    @Override
    public void delete(User user) {
        System.out.println("Google kullanicisi kaydini sildi. Kullanici veritabanindan silindi: " + user.getFirstName());
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
