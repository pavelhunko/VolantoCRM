package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
	return ok(views.html.index.render());
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
