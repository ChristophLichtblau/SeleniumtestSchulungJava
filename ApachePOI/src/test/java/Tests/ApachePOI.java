package Tests;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOI {
	
	
	public ArrayList<Object[]> getExcelData(String filepath) throws Exception{
	ArrayList<Object[]> output = new ArrayList<Object[]>(); 
	
	FileInputStream stream = new FileInputStream(filepath);
	
	XSSFWorkbook workbook = new XSSFWorkbook(stream);
	XSSFSheet worksheet = workbook.getSheet("Testform3");
	
for (Row row : worksheet) {
	if(row.getRowNum() >= 1) {
		Object [] values = new Object[row.getPhysicalNumberOfCells()];
		
		Iterator<Cell> cellIterator = row.cellIterator();
		
		int column = 0;
		while(cellIterator.hasNext()) {
			Cell cellValue = cellIterator.next();
			if(cellValue.getCellType() == CellType.STRING) {
				values[column] = cellValue.getStringCellValue();
			}else {
				values[column] = NumberToTextConverter.toText(cellValue.getNumericCellValue());
			}
			column++;
		}
		output.add(values);
	}
}
	return output;
	}
	


}
