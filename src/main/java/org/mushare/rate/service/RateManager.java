package org.mushare.rate.service;

import org.mushare.rate.service.common.Result;

import java.util.List;

public interface RateManager {

    Result getCurrent(String from, String to);

    Result getCurrentByFrom(String from);

    Result getCurrentByTo(String to);

}
