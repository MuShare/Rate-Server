package org.mushare.rate.service.impl;

import org.mushare.rate.bean.CurrencyBean;
import org.mushare.rate.domain.Currency;
import org.mushare.rate.service.CurrencyManager;
import org.mushare.rate.service.common.ManagerTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyManagerImpl extends ManagerTemplate implements CurrencyManager {

    public List<CurrencyBean> getCurrencies(int rev) {
        List<CurrencyBean> currencyBeans = new ArrayList<CurrencyBean>();
        for (Currency currency : currencyDao.findByRevison(rev)) {
            currencyBeans.add(new CurrencyBean(currency));
        }
        return currencyBeans;
    }
}
