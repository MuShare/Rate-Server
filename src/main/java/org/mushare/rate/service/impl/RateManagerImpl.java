package org.mushare.rate.service.impl;

import org.mushare.common.util.Debug;
import org.mushare.rate.domain.Currency;
import org.mushare.rate.domain.Rate;
import org.mushare.rate.service.RateManager;
import org.mushare.rate.service.common.ManagerTemplate;
import org.mushare.rate.service.common.Result;
import org.mushare.rate.service.common.ResultCode;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RateManagerImpl extends ManagerTemplate implements RateManager {

    public Result getCurrent(String fromCid, String toCid) {
        Currency from = currencyDao.get(fromCid);
        Currency to = currencyDao.get(toCid);
        if (from == null || to == null) {
            Debug.error("Cannot find currency by the cid.");
            return Result.objectIdError();
        }
        Rate fromRate = rateDao.getCurrentByCurrency(from);
        if (fromRate == null) {
            fromRate = rateComponent.refreshCurrency(from);
        }
        Rate toRate = rateDao.getCurrentByCurrency(to);
        if (toRate == null) {
            toRate = rateComponent.refreshCurrency(to);
        }
        Double result = toRate.getValue() / fromRate.getValue();
        return Result.successWithData(result);
    }

    public Result getCurrentByFrom(String fromCid) {
        Currency from = currencyDao.get(fromCid);
        if (from == null) {
            Debug.error("Cannot find currency by the cid.");
            return Result.objectIdError();
        }
        List<Rate> rates = rateDao.findCurrents();
        if (rates.size() < rateComponent.getCurrenciesCount()) {
            rateComponent.refreshCurrent();
            rates = rateDao.findCurrents();
        }
        Rate fromRate = null;
        for (Rate rate : rates) {
            if (rate.getCurrency().getCid().equals(fromCid)) {
                fromRate = rate;
                break;
            }
        }
        if (fromRate == null) {
            return Result.withCode(ResultCode.CurrencyNotFound);
        }
        Map<String, Double> results = new HashMap<String, Double>();
        for (Rate rate : rates) {
            if (rate.getCurrency().getCid().equals(fromCid)) {
                continue;
            }
            System.out.println(rate.getCurrency().getCid() + ", " + rate.getValue() / fromRate.getValue());
            results.put(rate.getCurrency().getCid(), rate.getValue() / fromRate.getValue());
        }
        return Result.successWithData(results);
    }

    public Result getCurrentByTo(String toCid) {
        Currency to = currencyDao.get(toCid);
        if (to == null) {
            Debug.error("Cannot find currency by the cid.");
            return Result.objectIdError();
        }
        List<Rate> rates = rateDao.findCurrents();
        if (rates.size() < rateComponent.getCurrenciesCount()) {
            rateComponent.refreshCurrent();
            rates = rateDao.findCurrents();
        }
        Rate toRate = null;
        for (Rate rate : rates) {
            if (rate.getCurrency().getCid().equals(toCid)) {
                toRate = rate;
                break;
            }
        }
        if (toRate == null) {
            return Result.withCode(ResultCode.CurrencyNotFound);
        }
        Map<String, Double> results = new HashMap<String, Double>();
        for (Rate rate : rates) {
            if (rate.getCurrency().getCid().equals(toCid)) {
                continue;
            }

            results.put(rate.getCurrency().getCid(), toRate.getValue() / rate.getValue());
        }
        return Result.successWithData(results);
    }

}
