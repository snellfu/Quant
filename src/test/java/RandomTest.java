import java.math.BigDecimal;
import java.util.Random;

public class RandomTest {

    public static double getRandomMoney(int remainSize, BigDecimal remainMoney) {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (remainSize == 1) {
            remainSize--;
            return (double) Math.round(remainMoney.doubleValue() * 100) / 100;
        }
        Random r = new Random();
        double min = 0.01;
        double max = remainMoney.doubleValue() / remainSize * 2;
        double money = r.nextDouble() * max;
        money = money < min ? 0.01 : money;
        money = Math.floor(money * 100) / 100;
        remainSize--;
        remainMoney = remainMoney.subtract(new BigDecimal(money));
        return money;
    }

    public static void main(String[] args) {
        //BigDecimal bigDecimal = new BigDecimal(100);
        double du = 10;
        double dd =0;
        double re =0;
        for (int i = 10; i > 1; i--) {
            //System.out.println();

            dd = RandomTest.getRandomMoney(i, new BigDecimal(du));
            re = du-dd;
            du =re;
            System.out.println(dd);

        }

    }
}
