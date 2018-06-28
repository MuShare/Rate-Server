package org.mushare.rate.service;

import org.mushare.rate.service.common.Result;

import java.util.List;

public interface RateManager {

    /**
     *
     * @param from
     * @param to
     * @return
     */
    Result getCurrent(String from, String to);

    /**
     *
     * @param from
     * @return
     */
    Result getCurrentByFrom(String from);

    /**
     *
     * @param to
     * @return
     */
    Result getCurrentByTo(String to);

    /**
     *
     * @param start
     * @param end
     * @param from
     * @param to
     * @return
     */
    Result getHistory(long start, long end, String from, String to);

}
