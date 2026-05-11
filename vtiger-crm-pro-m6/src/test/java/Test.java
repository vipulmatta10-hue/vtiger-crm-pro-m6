import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Test {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/testScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("org");
		Row  row = sh.getRow(1);
		Cell cell = row.getCell(0);
		Cell cell2 = row.getCell(2);
		Cell cell3 = row.getCell(3);
		String name = cell.getStringCellValue();
		boolean name1 = cell2.getBooleanCellValue();
	    double name2 = cell3.getNumericCellValue();
	    long longName = (long) name2;
		System.out.println(name);
		System.out.println(name1);
		System.out.println(longName);
		wb.close();
		
		
		

	}

}
