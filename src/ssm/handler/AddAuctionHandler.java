package ssm.handler;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import ssm.bean.AuctionBean;
import ssm.service.AuctionService;

@Controller
public class AddAuctionHandler {
	
	@Autowired
	private AuctionService auctionService;
	
	public AuctionService getAuctionService() {
		return auctionService;
	}

	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}

	@RequestMapping(value="/AddAuction",method=RequestMethod.POST)
	public String AddAuction(HttpServletRequest request,@RequestParam("auctionname")String auctionname,
	@RequestParam("auctionstartprice")String auctionstartprice,@RequestParam("auctionstarttime")String auctionstarttime,
	@RequestParam("auctionendtime")String auctionendtime,@RequestParam("auctiondesc")String auctiondesc,@RequestParam("auctionpic")String auctionpic) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
	    int  auctionstartpriceint=Integer.parseInt(auctionstartprice);
		String auctionpicfinal="images/"+auctionpic;
		AuctionBean auctionBean=new AuctionBean();
		auctionBean.setAuctionname(auctionname);
		auctionBean.setAuctionstartprice(auctionstartpriceint);
		auctionBean.setAuctionstarttime(auctionstarttime);
		auctionBean.setAuctionendtime(auctionendtime);
		auctionBean.setAuctiondesc(auctiondesc);
		auctionBean.setAuctionpic(auctionpicfinal);
	//	 AuctionService auctionService=new AuctionService();
		 auctionService.AuctionAdd(auctionBean);
		 return  "redirect:AuctionManager";
	}

}
