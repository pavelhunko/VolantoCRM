package models;

import java.util.Set;

public class Admin extends User {
    
    // can remove users from system 
    private static Set<User> users; 
    
    public static boolean remove (User user) {
	return users.remove(user);
    }
}
