package com.example.binlog_mysql;

import com.example.binlog_mysql.service.SyncTableService;
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.TableMapEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Component
@AllArgsConstructor
public class BinLogRun {
    private final SyncTableService syncData;

    void doSomething() throws IOException {
        BinaryLogClient client = new BinaryLogClient("localhost", 3306, "root", "Password123!@#");
        HashMap<Long, String> binLogTableId = new HashMap<>();

        client.registerEventListener(event -> {
            EventData data = event.getData();

            if (data instanceof TableMapEventData tableMapEvent) {
                long tableId = tableMapEvent.getTableId();
                String tableName = tableMapEvent.getTable();
                String databaseName = tableMapEvent.getDatabase();

                if(databaseName.equals("test_trigger_cdc"))
                    binLogTableId.put(tableId, tableName);

                System.out.println("table id : " + tableId + " table name :" + tableName);
            }

            if (data instanceof WriteRowsEventData) {
                long tableId = ((WriteRowsEventData) data).getTableId();

                if(binLogTableId.containsKey(tableId)){
                    List<Serializable[]> rows = ((WriteRowsEventData) data).getRows();

                    switch (binLogTableId.get(tableId)) {
                        case "your_tale_name" -> syncData.syncTableYourTableName(rows);
                        case "sensors" -> syncData.syncTableSensors(rows);
                        default -> System.out.println("untracked table change detected");
                    }
                }

            }
        });

        client.connect();
    }
}