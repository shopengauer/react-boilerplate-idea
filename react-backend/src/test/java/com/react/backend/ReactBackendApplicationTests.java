package com.react.backend;

import com.react.backend.workbook.WorkbookCreator;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactBackendApplicationTests {


	private final String testSheetName1 = "Test sheet 1";
	private final String testSheetName2 = "Test sheet 2";
	private final String testFileName1 = "test1.xls";
	private final String testFileName2 = "test2.xls";

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
