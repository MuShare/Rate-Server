package org.mushare.rate.bean;

import java.util.List;
import java.util.Map;

public class SubscribeSyncBean {
    private List<SubscribeMobileBean> createdOrUpdated;
    private List<String> deletedSubcribes;
    private Map<String, Double> rates;

    public List<SubscribeMobileBean> getCreatedOrUpdated() {
        return createdOrUpdated;
    }

    public void setCreatedOrUpdated(List<SubscribeMobileBean> createdOrUpdated) {
        this.createdOrUpdated = createdOrUpdated;
    }

    public List<String> getDeletedSubcribes() {
        return deletedSubcribes;
    }

    public void setDeletedSubcribes(List<String> deletedSubcribes) {
        this.deletedSubcribes = deletedSubcribes;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
