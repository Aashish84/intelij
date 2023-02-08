package org.example;

public class Container {
    public void container(int [] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < arr.length ; i++){
                for (int j = i+1; j < arr.length ; j++){
                    int l = Math.min(arr[i] , arr[j]);
                    int b = j-i;
                    int tmp = l * b;
                    if(max < tmp){
                        max = tmp;
                    }
                }
        }
        System.out.println(max);
    }
}
