package ssm.handler;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ExcelUtil.ExcelUtil;
import ssm.bean.AuctionBean;
import ssm.service.AuctionService;

@Controller
public class ExcelExportHandler {

	@Autowired
	private AuctionService auctionService;
	
	public AuctionService getAuctionService() {
		return auctionService;
	}

	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	@RequestMapping(value="/ExportExcel")
	public void ExportExcel(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		//获取数据
		  List<AuctionBean>list=auctionService.AllAuctionList();
		
		//excel标题
		String[] titles = {"名称","描述","开始时间","结束时间","起拍价"};
		
		//excel文件名
		String filename = "拍卖信息表"+System.currentTimeMillis()+".xls";
		
		//sheet名
		String sheetName = "拍卖信息表";
		
		String[][] content = new String[list.size()][];
		
		for (int i = 0; i < list.size(); i++)
		{
            content[i] = new String[titles.length];
            AuctionBean auctionBean = list.get(i);
            content[i][0] = auctionBean.getAuctionname().toString();
            content[i][1] = auctionBean.getAuctiondesc().toString();
            content[i][2] = auctionBean.getAuctionstarttime().toString();
            content[i][3] = auctionBean.getAuctionendtime().toString();
            int price = auctionBean.getAuctionstartprice();
            content[i][4] = String.valueOf(price);
		}
		
		//创建HSSFWorkbook 
		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, titles, content, null);
		
		try
		{
			this.setResponseHeader(response,filename);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
