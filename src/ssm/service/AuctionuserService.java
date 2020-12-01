package ssm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.bean.AuctionuserBean;
import ssm.mapper.AuctionuserMapper;



@Service
public class AuctionuserService {
	
	@Autowired
	private AuctionuserMapper auctionuserMapper;
	
	  public AuctionuserMapper getAuctionuserMapper() {
		return auctionuserMapper;
	}

	public void setAuctionuserMapper(AuctionuserMapper auctionuserMapper) {
		this.auctionuserMapper = auctionuserMapper;
	}

	public boolean UserNameisExisted(String username) {
		  boolean flag=false;		  	 
		  AuctionuserBean auctionuserBean=auctionuserMapper.UserNameisExisted(username);
		 if(auctionuserBean!=null) {
			 flag=true;
		 }
          return flag;
	  }
    	  
	  public boolean FindUserByIdandPwd(String  username, String passwd) {
		  String password=auctionuserMapper.FindUserByIdandPwd(username);
		  if(password.equals(passwd)) {
			  return true;
		  }
		    return false;		  
	  }
	  
	  public  int  IsAdmin(String username) {
		  int  flag=0; 
		  flag=auctionuserMapper.IsAdmin(username); 
		  return flag;
	  }
	  
	  public void AddUser(AuctionuserBean auctionuserBean) {
		  auctionuserMapper.AddUser(auctionuserBean);
	  }
	  
	  public int  UserId(String username) {
		  		
		 int userid= auctionuserMapper.UserId(username);
		 return userid;
	  }
//	  public  static void main(String args[]) {
//		    AuctionuserService auctionuserService=new AuctionuserService();
//		   System.out.println(auctionuserService.UserId("ali"));
//			
//	  }
}
