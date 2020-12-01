package ssm.handler;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LogOutHandler {

	
	@RequestMapping(value="/LogOut")
	 public String LogOut(HttpSession session) {
		session.invalidate();
		return"login";
	}

}
