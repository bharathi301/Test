package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Datadriven_writedatatoexcel 
{
	public static void writedata(String sheet,int row, int cell,String data)
	{
		try
		{
			FileInputStream fis = new FileInputStream("./excel/data.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Cell c = wb.getSheet(sheet).getRow(row).createCell(cell);
			c.setCellValue(data);
			FileOutputStream fout = new FileOutputStream("./excel/data.xlsx");
			wb.write(fout);
			
		}
		catch(Exception e)
		{
			System.out.println("");
		}
	}

}
