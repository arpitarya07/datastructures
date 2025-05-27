package Numbers;

public class PowerOfANumber {
    public static void main(String[] args) {
        PowerOfANumber powerOfANumber = new PowerOfANumber();
        powerOfANumber.powerOfANumber_O_n(3, 3);
    }

    public void powerOfANumber_O_n(int num, int power) {
        int i=1;
        int ans=1;
        while(i <= power) {
            ans = ans * num;
            i++;
        }
        System.out.println(ans);
    }

    public void powerOfANumber_O_Logn(int num, int power) {
        // 2^3 = 2 * 2 * 2 = 8 = (2^2) * 2
        // 2^4 = 2 * 2 * 2 * 2 = 16 = (2^2) * (2^2) = (2^2)^2
        // 2^7 = 2^6 * 2 = (2^2)^3 * 2
        // If power is even -> (num^2)^(power/2)
        // If power is odd -> num * num^(power-1)
        int i=1;
        int ans=1;
        while(power >= 1) {
            if (power%2 == 1) {  //2^7
                ans = ans * num; // ans = 1*2 = 2 || 2*4 = 16 || 16*8 = 128
            }
            num = num*num; // num = 2*2 = 4 || 4*2 = 8 || 8*8 = 64
            power = power/2; // power = 7/2 = 3 || 3/2 = 1 || 1/2 = .5 = 0
        }
        System.out.println(ans);
    }
}
