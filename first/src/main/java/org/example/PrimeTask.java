package org.example;


public class PrimeTask {
    public void primeNum(int maxLength){
        if(maxLength < 2){
            System.out.println("invalid max length");
            return;
        }

        for (int i = 2 ; i <= maxLength ; i ++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i+",");
            }
        }
        System.out.println();
    }
}
