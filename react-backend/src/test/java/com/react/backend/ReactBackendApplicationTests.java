package com.react.backend;

import com.react.backend.workbook.WorkbookCreator;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactBackendApplicationTests {

	private Logger logger = LoggerFactory.getLogger(ReactBackendApplicationTests.class);

	private final String testSheetName1 = "Test sheet 1";
	private final String testSheetName2 = "Test sheet 2";
	private final String testFileName1 = "test1.xls";
	private final String testFileName2 = "test2.xls";
	private final String testFileName3 = "test3.xls";
	private final String testFileName4 = "test4.xls";

	@Autowired
	private WorkbookCreator workbookCreator;

	@Test
	@Ignore
	public void fileEncodingTest() {
		testFileCreateTest();
	    byte[] bytes = getByteArrayFromFile(testFileName1);

	}

	@Test
 	public void workbookFilesEncodingTest() {
       Workbook wb1 = new HSSFWorkbook();
       Workbook wb2 = new HSSFWorkbook();
       wb1.createSheet(testSheetName1);
       wb2.createSheet(testSheetName1);
       workbookCreator.emptyXlsFileCreateFromWorkbook(testFileName1,wb1);
       workbookCreator.emptyXlsFileCreateFromWorkbook(testFileName2,wb2);

       byte[] fileByteArray1 = getByteArrayFromFile(testFileName1);
       byte[] fileByteArray2 = getByteArrayFromFile(testFileName2);

        Assert.assertArrayEquals(fileByteArray1,fileByteArray2);

	    String fileEncodeString1 = encodeBase64ByteArrayToString(fileByteArray1);
		String fileEncodeString2 = encodeBase64ByteArrayToString(fileByteArray2);

		logger.info("Encode string 1: {}",fileEncodeString1);
		logger.info("Encode string 2: {}",fileEncodeString2);

		System.out.println();

		Assert.assertEquals(fileEncodeString1,fileEncodeString2);

		byte[] fileDecodedArray1 = decodeBase64StringToByteArray(fileEncodeString1);
		byte[] fileDecodedArray2 = decodeBase64StringToByteArray(fileEncodeString2);

		Assert.assertArrayEquals(fileDecodedArray1,fileDecodedArray2);

        Workbook wbb1 = getWorkbookFromByteArray(fileDecodedArray1);
        Workbook wbb2 = getWorkbookFromByteArray(fileDecodedArray2);

        workbookCreator.emptyXlsFileCreateFromWorkbook(testFileName3,wbb1);
        workbookCreator.emptyXlsFileCreateFromWorkbook(testFileName4,wbb2);

	}




	private void testFileCreateTest(){
		Assert.assertNotNull(workbookCreator);
		Assert.assertTrue(workbookCreator.emptyXlsFileCreate(testFileName1, testSheetName1));
		Sheet sheet = workbookCreator.workbookFileRead(testFileName1).getSheet(testSheetName1);
		Assert.assertEquals(sheet.getSheetName(), testSheetName1);
	}

	private byte[] getByteArrayFromFile(String testFileName){
	    // get workbook from file
		Workbook wb =  workbookCreator.workbookFileRead(testFileName);
	    try(ByteArrayOutputStream bs = new ByteArrayOutputStream()) {
	    	wb.write(bs);
		    return bs.toByteArray();
			} catch (IOException e) {
			throw new RuntimeException("Error create byte array");
		}
	}


	private Workbook getWorkbookFromByteArray(byte[] byteArray){
	    // get workbook from array

		try (ByteArrayInputStream bs = new ByteArrayInputStream(byteArray)) {
			Workbook wb = WorkbookFactory.create(bs);
			return wb;
		} catch (IOException e) {
			throw new RuntimeException("Error create byte array");
		} catch (InvalidFormatException e) {
			throw new RuntimeException("Invalid format");
		}
	}

	private byte[] getByteArrayFromWorkbook(Workbook wb){
	    // get byte array from workbook
    	try(ByteArrayOutputStream bs = new ByteArrayOutputStream()) {
			wb.write(bs);
			return bs.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException("Error create byte array");
		}
	}

	private String encodeBase64ByteArrayToString(byte[] bytes){
         return Base64.encodeBase64String(bytes);
	}

    private byte[] decodeBase64StringToByteArray(String base64String){
         return Base64.decodeBase64(base64String);
	}




}
