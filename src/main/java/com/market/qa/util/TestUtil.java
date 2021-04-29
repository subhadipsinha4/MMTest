package com.market.qa.util;

import com.market.qa.baseTest.BaseTest;
import org.apache.commons.io.FileUtils;
import org.glassfish.grizzly.compression.lzma.impl.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil extends BaseTest {
     public static long PAGE_LOAD_TIME=10;
     public static long IMPLICIT_TIME=10;

     static JavascriptExecutor js;

     public static String TESTDATA_SHEET_LINK="C:\\Users\\unbxd\\IdeaProjects\\com.website.test\\src\\main\\java\\com\\market\\qa\\testData\\SearchQueryMM.xlsx";

     public TestUtil() throws IOException {
     }


//*************Retrive data from Excel 2d table*******************//
//     public static Object[][] getTestData(String sheetName) {
//          FileInputStream file = null;
//          try {
//               file = new FileInputStream(TESTDATA_SHEET_PATH);
//          } catch (FileNotFoundException e) {
//               e.printStackTrace();
//          }
//          try {
//               book = WorkbookFactory.create(file);
//          } catch (InvalidFormatException e) {
//               e.printStackTrace();
//          } catch (IOException e) {
//               e.printStackTrace();
//          }
//          sheet = book.getSheet(sheetName);
//          Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//          // System.out.println(sheet.getLastRowNum() + "--------" +
//          // sheet.getRow(0).getLastCellNum());
//          for (int i = 0; i < sheet.getLastRowNum(); i++) {
//               for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
//                    data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//                    // System.out.println(data[i][k]);
//               }
//          }
//          return data;
//     }

     public static void takeScreenshotAtEndOfTest() throws IOException {
          File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          String currentDir = System.getProperty("user.dir");
          FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
     }
}
