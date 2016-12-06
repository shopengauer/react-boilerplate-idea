package com.react.backend.workbook;

import com.react.backend.DateObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;

/**
 * Created by vasiliy on 04.12.16.
 */
@Component
public class WorkbookCreator {


  public boolean emptyXlsFileCreate(String filename, String sheetName){
    Workbook wb = new HSSFWorkbook();
    wb.createSheet(sheetName);
    try(FileOutputStream fs = new FileOutputStream(filename)) {
      wb.write(fs);
      return true;
    }catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean emptyXlsFileCreateFromWorkbook(String filename,Workbook wb){
    try(FileOutputStream fs = new FileOutputStream(filename)) {
      wb.write(fs);
      return true;
    }catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean emptyXlsFileCreateFromByteArray(String filename,byte[] bytes){
    try(FileOutputStream fs = new FileOutputStream(filename)) {
      fs.write(bytes);
      return true;
    }catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }



  public Workbook workbookFileRead(String filename){
    Workbook wb;
    try {
       wb = WorkbookFactory.create(new File(filename));
       return wb;
    } catch (IOException | InvalidFormatException e) {
      throw new RuntimeException("Error reading file");
    }
  }

  public String getWorkbookString(DateObject dateObject){
    Workbook wb = new HSSFWorkbook();
    wb.createSheet("Отчет по комиссии");
    try(ByteArrayOutputStream bs = new ByteArrayOutputStream(); FileOutputStream fs = new FileOutputStream("work.xls")){
      wb.write(bs);
     // System.out.println(Arrays.toString(bs.toByteArray()));
      String s = Base64.encodeBase64String(bs.toByteArray());

      return s;
    } catch (IOException e) {
       throw new RuntimeException("Error file creating");
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
