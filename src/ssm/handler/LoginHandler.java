package ssm.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import ssm.service.AuctionuserService;

@Controller
public class LoginHandler {
	@Autowired
private AuctionuserService auctionuserService;
	
public AuctionuserService getAuctionuserService() {
		return auctionuserService;
	}

	public void setAuctionuserService(AuctionuserService auctionuserService) {
		this.auctionuserService = auctionuserService;
	}

@RequestMapping(value="/Login",method=RequestMethod.POST)
public String Login(HttpServletRequest request,HttpSession session,@RequestParam("username")String username,@RequestParam("userpassword")String userpassword) {
	
//	AuctionuserService auctionuserService=new AuctionuserService();
	boolean  NameNotExisted=auctionuserService.UserNameisExisted(username);
	boolean  PwdIsWrong=auctionuserService.FindUserByIdandPwd(username, userpassword);
	if(NameNotExisted==false) {
		 request.setAttribute("msg", "用户名或密码错误！");
		 return "login";
	}else {
     	if(PwdIsWrong==false) {
      	 request.setAttribute("msg", "用户名或密码错误！");
      	 return "login";
    }else {		
			session.setAttribute("username", username);
			if(auctionuserService.IsAdmin(username)==1) {
				return  "redirect:AuctionManager";
			}else {
				return "redirect:Auction";
			}		
		}	
}
}
}