public class PrimeChecker {

    public static void main(String[] args) {
        PrimeChecker checker = new PrimeChecker();
        for (int i = 1; i <= 25; i++) {
            if(checker.isPrime(i)){
                System.out.println(i + " is a prime number!");
            }
            else{
                System.out.println(i + " is not a prime number :(");
            }
        }
    }

    private boolean isPrime(int n){
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
