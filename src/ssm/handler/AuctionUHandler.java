package ssm.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssm.bean.AuctionBean;
import ssm.service.AuctionService;

@Controller
public class AuctionUHandler {

	@Autowired
	private AuctionService auctionService;
	
	public AuctionService getAuctionService() {
		return auctionService;
	}

	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	@RequestMapping(value="/AuctionU")
	public String AuctionU(HttpSession session,@RequestParam("acutionid")String acutionid) {
		           int id=Integer.parseInt(acutionid);
			//	    AuctionService auctionService=new AuctionService();
					AuctionBean auctionBean=auctionService.Auction(id);
					session.setAttribute("auction", auctionBean);	
					return"update";
	}
}
