package ssm.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import ssm.bean.AuctionBean;
import ssm.service.AuctionService;

@Controller
public class AuctionHandler {
	
	@Autowired
	private AuctionService auctionService;
	
	public AuctionService getAuctionService() {
		return auctionService;
	}

	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}

	@RequestMapping(value="/Auction")
	public String Auction(HttpSession session) {
		
	//	   AuctionService auctionService=new AuctionService();
		   List<AuctionBean>list=auctionService.AllAuctionList();
		   session.setAttribute("auctionlist", list);	   
		   return "list";
	}

}
