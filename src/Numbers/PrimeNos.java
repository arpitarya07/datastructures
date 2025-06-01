package Numbers;

public class PrimeNos {
    public static void main(String[] args) {
        PrimeNos primeNos = new PrimeNos();
        primeNos.primeOrNot(12);
    }

    public void primeOrNot(int num) {
        boolean isPrime = true;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                isPrime = false;
                System.out.println("Not Prime");
                break;
            }
        }
        if (isPrime) {
            System.out.println("Prime");
        }
    }
}
