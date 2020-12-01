package ssm.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import ssm.service.AuctionService;

@Controller
public class DeleteAuctionHandler {
	
	@Autowired
	private AuctionService auctionService;
	
	public AuctionService getAuctionService() {
		return auctionService;
	}
	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}


	@RequestMapping(value="/DeleteAuction",method=RequestMethod.GET)
	public String DeleteAuction(@RequestParam("acutionid")String acutionid) {
		int  auctionidint=Integer.parseInt(acutionid);
	//	AuctionService auctionService=new AuctionService();
		auctionService.AuctionDelete(auctionidint);
	    return  "redirect:AuctionManager";
	}
	

}
