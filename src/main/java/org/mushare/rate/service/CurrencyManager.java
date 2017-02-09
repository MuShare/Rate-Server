package org.mushare.rate.service;

import org.mushare.rate.bean.CurrencyBean;

import java.util.List;

public interface CurrencyManager {

    /**
     * Get all kinds of currency.
     * @return
     */
    List<CurrencyBean> getCurrencies(int rev);

}
