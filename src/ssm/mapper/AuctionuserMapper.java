package ssm.mapper;

import org.springframework.stereotype.Repository;

import ssm.bean.AuctionuserBean;
@Repository
public interface AuctionuserMapper {

	public AuctionuserBean UserNameisExisted(String username);
	public String FindUserByIdandPwd(String  username);
	public  int  IsAdmin(String username);
	public void AddUser(AuctionuserBean auctionuserBean);
	public int  UserId(String username);
}
