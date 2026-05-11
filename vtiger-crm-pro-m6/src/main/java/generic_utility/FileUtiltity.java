package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtiltity {
	public String getDataFromPropertiesFile(String key) throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String value = pObj.getProperty(key);
		
		return value;
	}
	
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis2 = new FileInputStream("./src/test/resources/testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis2);

		Sheet sh = wb.getSheet(sheetName);

		Row row = sh.getRow(rowNum);

		Cell cell = row.getCell(cellNum);

		String value = cell.getStringCellValue() + JavaUtility.generateRandomNum();
		
		return value;
	}

}
