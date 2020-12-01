package ssm.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ssm.bean.AuctionuserBean;
import ssm.service.AuctionuserService;

@Controller
public class RegisterHandler {

	@Autowired
	private AuctionuserService auctionuserService;
	
	public AuctionuserService getAuctionuserService() {
		return auctionuserService;
	}

	public void setAuctionuserService(AuctionuserService auctionuserService) {
		this.auctionuserService = auctionuserService;
	}


	@RequestMapping(value="/Register",method=RequestMethod.POST)
	public String Register(@RequestParam("username")String username,@RequestParam("userpassword")String userpassword) {

	//	AuctionuserService auctionuserService=new AuctionuserService();
		AuctionuserBean auctionuser=new AuctionuserBean();
		auctionuser.setUsername(username);
		auctionuser.setUserpassword(userpassword);
		auctionuserService.AddUser(auctionuser);
		return"login";
	}

}
