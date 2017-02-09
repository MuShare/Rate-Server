package org.mushare.rate.service;

import org.mushare.rate.bean.CurrencyBean;

import java.util.List;

/**
 * Created by lee on 2017/2/3.
 */
public interface CurrencyManager {

    /**
     * Get all kinds of currency.
     * @return
     */
    List<CurrencyBean> getCurrencies(int rev);
}
