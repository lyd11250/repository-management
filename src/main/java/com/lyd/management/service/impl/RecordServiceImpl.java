package com.lyd.management.service.impl;

import com.lyd.management.dao.RecordMapper;
import com.lyd.management.model.Record;
import com.lyd.management.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    @Override
    public List<Record> getAllService() {
        return recordMapper.selectAll();
    }
}
