package org.mushare.rate.dao;

import org.mushare.common.hibernate.support.CrudDao;
import org.mushare.rate.domain.Currency;

import java.util.List;

/**
 * Created by lee on 2017/2/3.
 */
public interface CurrencyDao extends CrudDao<Currency> {

    /**
     * Get all the currency by revision
     * @param rev
     * @return
     */
    List<Currency> findByRevison(int rev);

    /**
     *
     * @param code
     * @return
     */
    Currency getByCode(String code);

    /**
     *
     * @return
     */
    int getMaxRev();

}
