public class Loops {
    
    public static void main(String[] args){
        System.out.println("Exercise 4.30");
        multiplesOfFive();
        
        System.out.println("Exercise 4.31");
        printSum();

        System.out.println("Exercise 4.32");
        System.out.println(sum(10,15));

        System.out.println("Exercise 4.33");
        System.out.println(isPrime(2));

    }

    //Exercise 4.30
    private static void multiplesOfFive(){
        int i = 10;
        while(i <= 95){
            System.out.println(i);
            i += 5;
        }
    }

    //Exercise 4.31
    private static void printSum(){
        int i = 1;
        int sum = 0;
        while(i <= 10 ){
            sum += i;
            i++;
        }
        System.out.println("Sum of numbers from 1 to 10: " + sum);
    }

    //Exercise 4.32
    private static int sum(int a, int b){
        int number = a;
        int sum = 0;
        while(number <= b){
            sum += number;
            number++;
        }
        return sum;
    }

     //Exercise 4.33
     private static boolean isPrime(int n){
        int i = 2;
        if(n < 2) return false;     //negative numbers, 1 and 0 are not prime
        while(i <= n-1){
            if(n % i == 0){
                return false;
            }
            else {
                i++;
            }
        }
        return true;
    }
}
