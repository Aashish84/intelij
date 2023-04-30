package com.example.custom_threadsafe.repo.repoImpl;

import com.example.custom_threadsafe.repo.CustomThreadSafe;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class CustomThreadSafeImpl implements CustomThreadSafe {
    private final EntityManagerFactory emf;

    public CustomThreadSafeImpl(@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void doSomethingThreadSafe() {
        EntityManager em = getEntityManager();
        try{
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
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
    private synchronized EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
