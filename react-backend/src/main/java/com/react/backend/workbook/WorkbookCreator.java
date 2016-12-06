package com.react.backend.workbook;

import com.react.backend.DateObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    wb.createSheet("Расчет");
    try(ByteArrayOutputStream bs = new ByteArrayOutputStream(); FileOutputStream fs = new FileOutputStream("work.xls")){
      wb.write(bs);
     // System.out.println(Arrays.toString(bs.toByteArray()));
      String s = Base64.encodeBase64String(bs.toByteArray());

    //  System.out.println(s);
    //  System.out.println(Arrays.toString(Base64.decodeBase64(s)));


      /*System.out.println(Base64.decodeBase64(s).length);
      System.out.println(Base64.encodeBase64String(bs.toByteArray()));*/

      return s;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }



}
