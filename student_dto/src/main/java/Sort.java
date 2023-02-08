import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int []arr = new int[] {5,1,4,2,8,9};

        for(int i = 0 ; i < arr.length-1 ; i++) {
            System.out.println("i : "+i);
            for(int j = 0 ; j < arr.length - i - 1 ; j++){
                System.out.println("j : "+j);
            }
        }

        System.out.println("==============");


        for(int i = 0 ; i < arr.length - 1 ; i ++){
            for (int j = 0 ; j < arr.length - i - 1 ; j++){
                if(arr[j] < arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for(int i : arr){
            System.out.println(i);
        }
    }
}
