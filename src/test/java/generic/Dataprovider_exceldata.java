package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Dataprovider_exceldata
{
	@DataProvider(name = "Auth")
	public static Object[][] getData()
	{
		Object data[][]=null;
		try
		{
			FileInputStream fis = new FileInputStream("./excel/data.xlsx");
		    Workbook wb = WorkbookFactory.create(fis);
		    Sheet sh = wb.getSheet("testdata");
		   int rc = sh.getLastRowNum();
		  Row r = sh.getRow(0);
		short cc = r.getLastCellNum();
		data = new Object[rc+1][cc];
		for(int i =0;i<rc+1;i++)
		{
			Row row = sh.getRow(i);
			for(int j =0;j<cc;j++)
			{
				Cell cell = row.getCell(j);
				String val = cell.getStringCellValue();
				data[i][j] = val;
			}
		}
		}
		
		catch(Exception e)
		{
			System.out.println("invalid path");
		}
		return data;
	}	
}
