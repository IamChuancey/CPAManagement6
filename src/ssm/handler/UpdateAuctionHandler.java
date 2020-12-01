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
public class UpdateAuctionHandler {
	@Autowired
	private AuctionService auctionService;
	
	public AuctionService getAuctionService() {
		return auctionService;
	}

	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	@RequestMapping(value="/UpdateAuction",method=RequestMethod.POST)
	public String UpdateAuction(HttpServletRequest request,@RequestParam("auctionid")String auctionid,@RequestParam("auctionname")String auctionname,
	@RequestParam("auctionstartprice")String auctionstartprice,@RequestParam("auctionstarttime")String auctionstarttime,
	@RequestParam("auctionendtime")String auctionendtime,@RequestParam("auctiondesc")String auctiondesc,@RequestParam("auctionpic")String auctionpic) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		    int id=Integer.parseInt(auctionid);
		    int  auctionstartpriceint=Integer.parseInt(auctionstartprice);
			String auctionpicfinal="images/"+auctionpic;
			AuctionBean auctionBean=new AuctionBean();
			auctionBean.setAuctionid(id);
			auctionBean.setAuctionname(auctionname);
			auctionBean.setAuctionstartprice(auctionstartpriceint);
			auctionBean.setAuctionstarttime(auctionstarttime);
			auctionBean.setAuctionendtime(auctionendtime);
			auctionBean.setAuctiondesc(auctiondesc);
			auctionBean.setAuctionpic(auctionpicfinal);
			auctionService.AuctionUpdate(auctionBean);
			return  "redirect:AuctionManager";
	}
	
}
