package com.example.customrepository_impl.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
public class CustomPersonRepoImpl implements CustomPersonRepo{
    @PersistenceContext
    private EntityManager em;
    @Override
    public void doSomething() {
        String str = "row (\"Temperature\",\"2S3-B962\",\"pelican\"), row(\"analog-input_8\",\"2749\",\"bacnet\")";
        String query = "with alerts_table(sensor_primary_id, sensor_secondary_id,  sensor_protocol)\n" +
                "as (values \n" +
                " %s "+
                ")\n" +
                "select * from alerts_table;";

        Query query1 = em.createNativeQuery(String.format(query, str));
        List<Object[]> resultList = query1.getResultList();
        resultList.forEach(row -> {
            String pid =row[0].toString();
            String sid = row[0].toString();
            String sp =row[1].toString();
            System.out.println("sensor_primary_id : " + pid + ", sensor_secondary_id : " + sid+", sensor_protocol : "+sp);
        });
    }
}

//        String query = "select p.id , p.person_name from Person as p";
//        Query query1 = em.createNativeQuery(query);
//        List<Object[]> resultList = query1.getResultList();
//        resultList.forEach(row -> {
//            BigInteger id = (BigInteger) row[0];
//            String personName = (String) row[1];
//            System.out.println("id: " + id + ", personName: " + personName);
//        });
