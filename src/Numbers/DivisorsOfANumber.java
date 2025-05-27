package Numbers;

public class DivisorsOfANumber {
    public static void main(String[] args) {
        DivisorsOfANumber divisorsOfANumber = new DivisorsOfANumber();
        divisorsOfANumber.divisorsOfANumber(100);
    }

    public void divisorsOfANumber(int num) {
        // Divisors always appear in a pair - e.g. 1,100 2,50 4,25 5,20 10,10 - are all divisors of 100
        for (int i = 1; i <= num / i; i++) {
            if (num % i == 0) {
                if (i != num / i) {
                    System.out.println(i + "," + num / i);
                } else {
                    System.out.println(i);
                }
            }
        }
    }


}
