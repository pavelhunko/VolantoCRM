package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class User extends Model {

    @Id
    public Long id;
    public String name;
    public String email;
    public String phone;
    public String companyName;
    public String streetAddress;

    
    public static Finder<Long, User> find = new Finder(Long.class, User.class);

    public static List<User> all() {
	return find.all();
    }

    public static void create(User user) {
	user.save();
    }

    public static User findByEmail(String email) {
	return find.where().eq("email", email).findUnique();
    }

    public static User findById(Long id) {
	return find.ref(id);
    }
}