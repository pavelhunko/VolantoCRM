package controllers;

import java.util.List;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.api.data.Form.*;

public class Application extends Controller {
    //now use in-memory db    
    static Form<User> userForm = Form.form(User.class);
    
    static User user = new User();
   
    public static Result index() {
	List<User> users = User.find.all();
	return ok(views.html.index.render(users));
    }
    
    public static Result register(){
	return ok(views.html.register.render(userForm));
    }

    public static Result newUser() {
	Form<User> filledForm = userForm.bindFromRequest();
	if (filledForm.hasErrors()) {
	    return redirect(routes.Application.index());
	} else {
	    User.create(filledForm.get());
	    return redirect(routes.Application.show(filledForm.get().id));
	}
    }
    
    public static Result show(Long id) {
	   return ok(views.html.show.render(user));
	}

}
