package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class InertialTask {

    public int inertial(int [] arr){

        int max = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;
        boolean containsOdd = false;

        ArrayList<Integer> allEven = new ArrayList<>();
        ArrayList<Integer> allOdd = new ArrayList<>();


        for(int i : arr) {
//            all even and odd
            if(i%2 == 0 ){
                allEven.add(i);
            }else{
                if(minOdd > i){
                    minOdd = i;
                }
                allOdd.add(i);
            }

//            CONTAINS ODD OR NOT
            if (!containsOdd) {
                if (i % 2 != 0) {
                    containsOdd = true;
                }
            }

//            MAX VALUE
            if (i > max) {
                max = i;
            }

        }

//        contains odd
        if(!containsOdd){return 0;}

//            max value is even
        if(max%2 != 0 ){
           return 0;
        }
//                every odd is greater than every even value
        allEven.remove(Integer.valueOf(max));
        boolean flag = true;
        for(int i  : allEven){
            if(i > minOdd){
                flag = false;
                break;
            }
        }

        if(!flag){
            return 0;
        }


        return 1;
    }
}
