package com.example.binlog_mysql.service;

import com.example.binlog_mysql.models.Sensors;
import com.example.binlog_mysql.models.YourTableName;
import com.example.binlog_mysql.repo.SensorsRepo;
import com.example.binlog_mysql.repo.YourTableNameRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SyncTableService {
    private final YourTableNameRepo yourTableNameRepo;
    private final SensorsRepo sensorsRepo;

    public void syncTableYourTableName(List<Serializable[]> rows) {

        List<YourTableName> tableRowList = new ArrayList<>();

        for (Serializable[] row : rows) {
            YourTableName temp = new YourTableName();
            if (row[0] != null)
                temp.setId((Integer) row[0]);
            if (row[1] != null)
                temp.setName(row[1].toString());
            if (row[2] != null)
                temp.setEmail(row[2].toString());
            tableRowList.add(temp);
        }
        yourTableNameRepo.saveAll(tableRowList);
    }

    public void syncTableSensors(List<Serializable[]> rows){
        List<Sensors> tableRowList = new ArrayList<>();
        for (Serializable[] row:rows) {
            Sensors temp = new Sensors();
            if(row[0] != null)
                temp.setId((long) row[0]);
            if(row[1] != null)
                temp.setSensorName(row[1].toString());
            if(row[2]!= null)
                temp.setStatus(row[2].toString());
            tableRowList.add(temp);
        }
        sensorsRepo.saveAll(tableRowList);
    }
}
