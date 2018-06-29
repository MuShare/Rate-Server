package org.mushare.rate.service.impl;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.mushare.rate.bean.CurrencyBean;
import org.mushare.rate.domain.Currency;
import org.mushare.rate.service.CurrencyManager;
import org.mushare.rate.service.common.ManagerTemplate;
import org.mushare.rate.service.common.Result;
import org.mushare.rate.service.common.ResultCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RemoteProxy(name = "CurrencyManager")
public class CurrencyManagerImpl extends ManagerTemplate implements CurrencyManager {

    public Result getCurrencies(int rev, String lan) {
        List<CurrencyBean> currencyBeans = new ArrayList<CurrencyBean>();
        for (Currency currency : currencyDao.findByRevison(rev)) {
            currencyBeans.add(new CurrencyBean(currency, lan));
        }
        return Result.successWithData(currencyBeans);
    }

    @RemoteMethod
    public Result addCurrency(String code) {
        if (!Arrays.asList(ApiSurpporttedCurrency).contains(code)) {
            return Result.withCode(ResultCode.CurrencyNotSupported);
        }
        Currency base = currencyDao.getByCode(BaseCurrencyCode);
        if (base == null) {
            base = new Currency();
            base.setCode(BaseCurrencyCode);
            base.setRevision(0);
            currencyDao.save(base);
        }
        Currency currency = currencyDao.getByCode(code);
        if (currency != null) {
            return Result.withCode(ResultCode.CurrencyExsited);
        }
        currency = new Currency();
        currency.setCode(code);
        currency.setRevision(currencyDao.getMaxRev() + 1);
        if (currencyDao.save(currency) == null) {
            return Result.saveInternalError();
        }
        rateComponent.loadHistoryForCurrency(currency);
        return Result.success();
    }

    @RemoteMethod
    public Result addAll() {
        if (rateComponent.getCurrenciesCount() < CurrencyManager.ApiSurpporttedCurrency.length) {
            List<String> codes = new ArrayList<String >(Arrays.asList(CurrencyManager.ApiSurpporttedCurrency));
            for (Currency currency : currencyDao.findAll()) {
                codes.remove(currency.getCode());
            }
            for (String code : codes) {
                Result result = addCurrency(code);
                System.out.println("Add new currency " + code + ", success = " + result.isSuccess());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            rateComponent.refreshCurrenciesCount();
            return Result.successWithData(codes.size());
        }
        return Result.successWithData(0);
    }

}
