import com.cjie.commons.okex.open.api.utils.Base64;
import org.hashids.Hashids;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HashidsTest {

    private static int corePoolSize = Runtime.getRuntime().availableProcessors();

    private static ThreadPoolExecutor executor  = new ThreadPoolExecutor(corePoolSize, corePoolSize+1, 10l, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1000));

    public static void main(String[] args) {

        Hashids hashids = new Hashids("this is my salt",8);
        String hash = hashids.encode(683L, 94108L, 123L, 5L);

        System.out.println(hash);
        long[] numbers = hashids.decode("aBMswoO2UB3Sj");

        System.out.println(numbers[0]+"--"+numbers[1]);


        // for (int i = 0; i < 1000; i++) {
        //     final long userId = i;
        //     Runnable task = new Runnable() {
        //         @Override
        //         public void run() {
        //             Hashids hashids = new Hashids("12344444", 8);
        //             String hash = hashids.encodeHex("https://www.baidu.com/s?wd=Runtime.getRuntime().availableProcessors()%3B&rsv_spt=1&rsv_iqid=0xc4aea66300037606&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=1");
        //             System.out.println(hash);
        //         }
        //     };
        //     executor.execute(task);
        // }
        // try {
        //     Thread.sleep(10000);
        //
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
    }
}
