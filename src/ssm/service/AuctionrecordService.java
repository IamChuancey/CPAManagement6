package ssm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.bean.AuctionrecordBean;
import ssm.mapper.AuctionrecordMapper;

@Service
public class AuctionrecordService {
	
	@Autowired
	private AuctionrecordMapper auctionrecordMapper;
	
	public AuctionrecordMapper getAuctionrecordMapper() {
		return auctionrecordMapper;
	}
	public void setAuctionrecordMapper(AuctionrecordMapper auctionrecordMapper) {
		this.auctionrecordMapper = auctionrecordMapper;
	}
	
	public List<AuctionrecordBean>  AuctionRecord(int auctionid){
		  	  
		  List<AuctionrecordBean>list=auctionrecordMapper.AuctionRecord(auctionid);
		  return list;
		
	}
	public void InsertionAuction(AuctionrecordBean auctionrecordBean) {
		    
		  auctionrecordMapper.InsertionAuction(auctionrecordBean);
		 
	}
	
//	public static void main(String args[]) {
////	  AuctionrecordService auctionrecordService=new AuctionrecordService();
////	  List<AuctionrecordBean>list=auctionrecordService.AuctionRecord(1);
////	  for(AuctionrecordBean auctionrecordBean:list) {
////		  System.out.println(auctionrecordBean.getAuctionprice());
////	  }
//		AuctionrecordService auctionrecordService=new AuctionrecordService();
//		AuctionrecordBean auctionrecordBean=new AuctionrecordBean();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		String date=df.format(new Date());
//		auctionrecordBean.setAuctionid(1);
//		auctionrecordBean.setAuctiontime(date);
//		auctionrecordBean.setAuctionprice(13121);
//		auctionrecordBean.setUserid(1);
//		auctionrecordService.InsertionAuction(auctionrecordBean);
//  }
}
