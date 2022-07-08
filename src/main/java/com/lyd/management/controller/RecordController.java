package com.lyd.management.controller;

import com.lyd.management.model.Record;
import com.lyd.management.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value="record")
public class RecordController {

    @Autowired
    RecordService recordService;

    @RequestMapping(value = "/list")
    public List<Record> getAll(){
        return recordService.getAllService();
    }
}
