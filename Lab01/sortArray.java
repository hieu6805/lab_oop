import java.util.Arrays;
import java.util.Scanner;
public class sortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int i;
        double sum=0;
        for(i=0;i<n;i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        System.out.println("The sorted array is: ");
        for(i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("The sum of the elements of the array is: "+sum);
        System.out.println("The average of the elements of the array is: "+(sum/n));
}
}