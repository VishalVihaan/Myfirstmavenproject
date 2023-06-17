package utils;

public class TestExcelReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//By giving the path with file name itself  - when you are placing excel files at diff paths
				//By giving only file name  - when you are placing files at the same location
				ExcelReader excel = new ExcelReader("Book1.xlsx","test");
				//Object[][] data = excel.getData();
				ExcelReader excel2 = new ExcelReader("Book2.xlsx");
				//Object[][] data2 = excel.getData();
				//Book1.xlsx
				System.out.println(excel.getRowNum());
				System.out.println(excel.getColNum());
				
				//Book2.xlsx
				System.out.println(excel2.getRowNum());
				System.out.println(excel2.getColNum());
				
				System.out.println(excel.getData(5));
				
				
				System.out.println(excel2.getData(1));
				
				
				ExcelReader cred = new ExcelReader("credentials.xlsx");
				
				System.out.println(cred.getDataInMap(1) +""+ cred.getDataInMap(2));
				
			}
			

		
	}


