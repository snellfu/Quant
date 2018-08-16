package com.cjie.commons.okex.open.api.task;


import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MineTask {

    @Autowired
    private MineService mineService;

    @Scheduled(cron = "*/3 * * * * ?")
    public void mineCurrency1() throws JobExecutionException {
        MineTask.log.info("start mining");
        //log.info(JSON.toJSONString(spotAccountAPIService.getAccountByCurrency("btc")));
        try {
            mineService.mine1("coinall", "cac", "usdt", 0.002);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MineTask.log.info("end mining");


    }
//    @Scheduled(cron = "2 */1 * * * ?")
//    public void mineCurrency3() throws JobExecutionException {
//        MineTask.log.info("start mining");
//        //log.info(JSON.toJSONString(spotAccountAPIService.getAccountByCurrency("btc")));
//        try {
//            mineService.mine3("coinall", "okb", "usdt", 0.005, 0.5);
//            //mineService.mine3("cac", "eth", 0.005);
//        } catch (Exception e) {
//            MineTask.log.error("error mining", e);
//        }
//        MineTask.log.info("end mining");
//
//
//    }
}
