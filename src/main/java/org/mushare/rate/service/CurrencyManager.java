package org.mushare.rate.service;

import org.mushare.rate.bean.CurrencyBean;
import org.mushare.rate.service.common.Result;

import java.util.List;

public interface CurrencyManager {

    public final static String BaseCurrencyCode = "USD";
    public static final String ApiSurpporttedCurrency[] = {"EUR", "GBP", "AUD", "BRL", "CAD", "CHF", "CNY", "DKK", "HKD", "INR", "JPY", "KRW", "LKR", "MYR"
            , "NZD", "SGD", "TWD", "ZAR", "THB", "SEK", "NOK", "MXN", "BGN", "CZK", "HUF", "LTL", "LVL", "PLN", "RON", "ISK", "HRK", "RUB",
            "TRY", "PHP", "COP", "ARS", "CLP", "SVC", "TND", "PYG", "MAD", "JMD", "SAR", "QAR", "HNL", "SYP", "KWD", "BHD", "EGP", "OMR", "NGN", "PAB", "PEN", "UYU"};

    /**
     * Get all kinds of currency.
     *
     * @return
     */
    Result getCurrencies(int rev, String lan);

    /**
     *
     *
     * @param code
     * @return
     */
    Result addCurrency(String code);

}
