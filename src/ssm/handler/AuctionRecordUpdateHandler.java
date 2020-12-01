package ssm.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ssm.bean.AuctionrecordBean;
import ssm.service.AuctionrecordService;
import ssm.service.AuctionuserService;

@Controller
public class AuctionRecordUpdateHandler {
	
	@Autowired
	private AuctionuserService auctionuserService;
	public AuctionuserService getAuctionuserService() {
		return auctionuserService;
	}
	public void setAuctionuserService(AuctionuserService auctionuserService) {
		this.auctionuserService = auctionuserService;
	}
	@Autowired
	private AuctionrecordService auctionrecordService;
	public AuctionrecordService getAuctionrecordService() {
		return auctionrecordService;
	}
	public void setAuctionrecordService(AuctionrecordService auctionrecordService) {
		this.auctionrecordService = auctionrecordService;
	}
	
	@RequestMapping(value="/AuctionRecordUpdate",method=RequestMethod.GET)
	public void AuctionRecordUpdate(HttpServletResponse response,@RequestParam("username")String username,@RequestParam("acutionid")String acutionid,@RequestParam("acutionprice")String acutionprice) throws IOException {
		int  acutionidint=Integer.parseInt(acutionid);
		int acutionpriceint=Integer.parseInt(acutionprice);
		//根据用户名查询得到用户id
//	    AuctionuserService auctionuserService=new AuctionuserService();
		int  userid=auctionuserService.UserId(username);
//		 AuctionrecordService auctionrecordService=new AuctionrecordService();
		    AuctionrecordBean auctionrecordBean=new AuctionrecordBean();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date=df.format(new Date());
			auctionrecordBean.setAuctionid(acutionidint);
			auctionrecordBean.setAuctiontime(date);
			auctionrecordBean.setAuctionprice(acutionpriceint);
			auctionrecordBean.setUserid(userid);
		    auctionrecordService.InsertionAuction(auctionrecordBean);
		    response.setContentType("text/xml;charset=utf-8");
			PrintWriter out=response.getWriter();		
		    out.println("<msn>"+"竞拍成功！"+"</msn>");   
		    out.flush();
			out.close();
	}

}
