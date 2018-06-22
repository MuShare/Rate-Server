package org.mushare.rate.service;

import org.mushare.rate.bean.CurrencyBean;
import org.mushare.rate.service.common.Result;

import java.util.List;

public interface CurrencyManager {

    public final static String BaseCurrencyCode = "USD";

    /**
     * Get all kinds of currency.
     *
     * @return
     */
    List<CurrencyBean> getCurrencies(int rev);

    /**
     *
     *
     * @param code
     * @return
     */
    Result addCurrency(String code);

}
