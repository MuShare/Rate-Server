package org.mushare.rate.controller;

import org.mushare.rate.controller.common.ControllerTemplate;
import org.mushare.rate.controller.common.ErrorCode;
import org.mushare.rate.service.common.Result;
import org.mushare.rate.service.common.ResultCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/api/rate")
public class RateController extends ControllerTemplate {

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public ResponseEntity getCurrentRates(String from, String to) {
        if (from != null && to != null) {
            final Result result = rateManager.getCurrent(from, to);
            if (result.getCode() == ResultCode.ObjectIdError) {
                return generateBadRequest(ErrorCode.ObjectIdError);
            }
            if (result.isSuccess()) {
                return generateOK(new HashMap<String, Object>() {{
                    put("rate", result.getData());
                }});
            }
        }
        if (from != null && to == null) {
            final Result result = rateManager.getCurrentByFrom(from);
            if (result.getCode() == ResultCode.ObjectIdError) {
                return generateBadRequest(ErrorCode.ObjectIdError);
            }
            if (result.isSuccess()) {
                return generateOK(new HashMap<String, Object>(){{
                    put("rates", result.getData());
                }});
            }
        }
        if (from == null && to != null) {
            final Result result = rateManager.getCurrentByFrom(to);
            if (result.getCode() == ResultCode.ObjectIdError) {
                return generateBadRequest(ErrorCode.ObjectIdError);
            }
            if (result.isSuccess()) {
                return generateOK(new HashMap<String, Object>(){{
                    put("rates", result.getData());
                }});
            }
        }
        return generateBadRequest(ErrorCode.FromAndToAreNull);
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ResponseEntity getHistoryRates(long start, long end, String from, String to) {
        final Result result = rateManager.getHistory(start, end, from, to);
        if (!result.isSuccess()) {
            return generateBadRequest(ErrorCode.ObjectIdError);
        }
        return generateOK(new HashMap<String, Object>(){{
            put("data", result.getData());
        }});
    }

}
