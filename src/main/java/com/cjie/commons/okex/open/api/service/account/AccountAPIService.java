package com.cjie.commons.okex.open.api.service.account;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cjie.commons.okex.open.api.bean.account.param.Transfer;
import com.cjie.commons.okex.open.api.bean.account.param.Withdraw;
import com.cjie.commons.okex.open.api.bean.account.result.Currency;
import com.cjie.commons.okex.open.api.bean.account.result.Ledger;
import com.cjie.commons.okex.open.api.bean.account.result.Wallet;
import com.cjie.commons.okex.open.api.bean.account.result.WithdrawFee;

import java.util.List;


public interface AccountAPIService {

    JSONObject transfer(Transfer transfer);

    JSONObject withdraw(Withdraw withdraw);

    List<Currency> getCurrencies();

    List<Ledger> getLedger(Integer type, String currency, Integer before, Integer after, int limit);

    List<Wallet> getWallet();

    List<Wallet> getWallet(String currency);

    JSONArray getDepositAddress(String currency);

    List<WithdrawFee> getWithdrawFee(String currency);

}
