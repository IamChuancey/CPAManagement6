package ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import ssm.bean.AuctionrecordBean;
@Repository
public interface AuctionrecordMapper {
	 public List<AuctionrecordBean>  AuctionRecord(int auctionid);
	 public void InsertionAuction(AuctionrecordBean auctionrecordBean);
}
