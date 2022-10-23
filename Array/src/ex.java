import java.util.Scanner;

public class ex {

    public static int processCase(int t){
        Scanner sc = new Scanner(System.in);

//            System.out.println("Input M and N:");
        // Read in the input for a single case
        long n = sc.nextInt(), m = sc.nextInt();

        //compute the total amount of candy
        long total_candy = 0;
        while(n-->0){
            total_candy += sc.nextInt();
        }
//        System.out.println("Case #"+t+": "+(total_candy % m));
        return (int)(total_candy % m);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("Input test cases :");
        int t = sc.nextInt();
        int[] res = new int[t];
        for(int i = 1; i <= t; i++){
            res[i - 1] = processCase(i);
        }
        for(int i = 0; i < t; i++){
            System.out.println("Case #"+t+": "+res[i]);
        }
    }
}

/*
2
7 3
1 2 3 4 5 6 7
5 10
7 7 7 7 7

 */