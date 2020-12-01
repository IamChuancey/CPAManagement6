package ExcelUtil;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {

	public static HSSFWorkbook getHSSFWorkbook(String sheetName,String []title,String [][]values, HSSFWorkbook wb) 
	{
		
		if ( wb == null )
			wb = new HSSFWorkbook();
		
		HSSFSheet sheet = wb.createSheet(sheetName);
		
		
		HSSFRow row = sheet.createRow(0);
		
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		
	
		HSSFCell cell = null;
		
		for ( int i = 0; i < title.length; i++ )
		{
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		
	
		for ( int i = 0; i < values.length; i++ )
		{
			row = sheet.createRow( i + 1 );
			for ( int j = 0; j < values[i].length ; j++ )
			{
				
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		
		return wb;
	}
	
	
}
