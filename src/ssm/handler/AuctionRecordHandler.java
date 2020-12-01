package ssm.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import ssm.bean.AuctionBean;
import ssm.bean.AuctionrecordBean;
import ssm.service.AuctionService;
import ssm.service.AuctionrecordService;

@Controller
public class AuctionRecordHandler {
	
	@Autowired
	private AuctionrecordService auctionrecordService;
	
	public AuctionrecordService getAuctionrecordService() {
		return auctionrecordService;
	}

	public void setAuctionrecordService(AuctionrecordService auctionrecordService) {
		this.auctionrecordService = auctionrecordService;
	}
	@Autowired
	private AuctionService auctionService;
	
	public AuctionService getAuctionService() {
		return auctionService;
	}

	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}

	@RequestMapping(value="/AuctionRecord")
	public String AuctionRecord(HttpSession session,@RequestParam("acutionid")String acutionid) {
		    int id=Integer.parseInt(acutionid);
	//	    AuctionService auctionService=new AuctionService();
			AuctionBean auctionBean=auctionService.Auction(id);
			session.setAttribute("auction", auctionBean);	
	//		AuctionrecordService auctionrecordService=new AuctionrecordService();
			List<AuctionrecordBean>list=auctionrecordService.AuctionRecord(id);
			session.setAttribute("record", list);
			int maxAuctionPrice=1;
			for(AuctionrecordBean auction:list) {
				if(auction.getAuctionprice()>=maxAuctionPrice)
					maxAuctionPrice=auction.getAuctionprice();
			}
			session.setAttribute("maxprice", maxAuctionPrice);
			session.setAttribute("acutionid", id);
		    return"auction";
	}

}
