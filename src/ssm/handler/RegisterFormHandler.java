package ssm.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ssm.service.AuctionuserService;

@Controller
public class RegisterFormHandler {
	
	@Autowired
	private AuctionuserService auctionuserService;
	
	public AuctionuserService getAuctionuserService() {
		return auctionuserService;
	}
	public void setAuctionuserService(AuctionuserService auctionuserService) {
		this.auctionuserService = auctionuserService;
	}


	@RequestMapping(value = "/RegisterForm", method = RequestMethod.GET)
	public void RegisterForm(HttpServletResponse response, @RequestParam("username") String username)
			throws IOException {
	//	AuctionuserService auctionuserService = new AuctionuserService();
		boolean UserisExist = auctionuserService.UserNameisExisted(username);
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (UserisExist == true) {
			// System.out.println("用户名已存在！");
			out.println("<msg>" + "existed" + "</msg>");
		}
		out.flush();
		out.close();

	}

}
