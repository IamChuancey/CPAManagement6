package ssm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.bean.AuctionBean;
import ssm.mapper.AuctionMapper;

@Service
public class AuctionService {
	
	@Autowired
	private AuctionMapper auctionMapper;
	
	public AuctionMapper getAuctionMapper() {
		return auctionMapper;
	}

	public void setAuctionMapper(AuctionMapper auctionMapper) {
		this.auctionMapper = auctionMapper;
	}

	public List<AuctionBean>   AllAuctionList() {
			 
		  List<AuctionBean>list=auctionMapper.AllAuctionList();
		  return list;
	}

	public void  AuctionDelete(int auctionid) {
	  
		  auctionMapper.AuctionDelete(auctionid);	  
		 
	}
	
	public AuctionBean  Auction(int auctionid) {
		
		  AuctionBean auctionBean=auctionMapper.Auction(auctionid);
		
	 	  return auctionBean;	  
	}
	
	 public  void  AuctionAdd(AuctionBean auctionBean) {
		 
		  auctionMapper.AuctionAdd(auctionBean);
		  
	 }
	 
	 public void AuctionUpdate(AuctionBean auctionBean) {
		
		 auctionMapper.AuctionUpdate(auctionBean);
	 }
	 
//	public static void main(String args[]) {
//		AuctionService auctionService=new AuctionService();
//		AuctionBean auctionBean=new AuctionBean();
//		auctionBean.setAuctiondesc("nihap");
//		auctionBean.setAuctionendtime("1243332");
//		auctionBean.setAuctionname("nihap");
//		auctionBean.setAuctionstartprice(121212);
//		auctionService.AuctionAdd(auctionBean);
//	}
	 
}
