package com.cjie.commons.okex.open.api.task;


import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
@Slf4j
public class CoinAllMineTask {

    @Autowired
    private CoinAllMineService mineService;

    //@Scheduled(cron = "* */2 * * * ?")
    public void mineCurrency1() throws JobExecutionException {
        CoinAllMineTask.log.info("start mining");
        //log.info(JSON.toJSONString(spotAccountAPIService.getAccountByCurrency("btc")));
        try {
            mineService.mine1("cac", "eth", 0.005);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CoinAllMineTask.log.info("end mining");


    }
    //@Scheduled(cron = "2 */1 * * * ?")
    public void mineCurrency3() throws JobExecutionException {
        CoinAllMineTask.log.info("start mining");
        //log.info(JSON.toJSONString(spotAccountAPIService.getAccountByCurrency("btc")));
        try {
            mineService.mine3("okb", "usdt", 0.005, 0.7);
            //mineService.mine3("cac", "eth", 0.005);
        } catch (Exception e) {
            CoinAllMineTask.log.error("error mining", e);
        }
        CoinAllMineTask.log.info("end mining");


    }
}
