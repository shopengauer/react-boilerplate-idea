package com.react.backend;

import com.react.backend.workbook.WorkbookCreator;
import com.react.backend.workbook.WorkbookObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vasiliy on 22.11.16.
 */
@Controller
public class HomeController {


    private final WorkbookCreator workbookCreator;

    @Autowired
    public HomeController(WorkbookCreator workbookCreator) {
        this.workbookCreator = workbookCreator;
    }

    @RequestMapping(value = "/json")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080")
    WorkbookObject index(){
       return new WorkbookObject(1,"Test workbook text");
    }

    @RequestMapping(value = "/workbook",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8080")
    WorkbookObject getWorkbook(DateObject dateObject){

        System.out.println(dateObject.getStartDate());
        System.out.println(dateObject.getEndDate());
       return new WorkbookObject(1,workbookCreator.getWorkbookString(new DateObject()));

    }
}
