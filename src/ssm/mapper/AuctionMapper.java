package ssm.mapper;


import java.util.List;

import org.springframework.stereotype.Repository;

import ssm.bean.AuctionBean;
@Repository
public interface AuctionMapper {
	public List <AuctionBean>  AllAuctionList();
	public void  AuctionDelete(int auctionid);
	public AuctionBean  Auction(int auctionid);
	public  void AuctionAdd(AuctionBean auctionBean);	
	public void AuctionUpdate(AuctionBean auctionBean);
}
