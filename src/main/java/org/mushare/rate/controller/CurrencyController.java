package org.mushare.rate.controller;

import org.mushare.rate.controller.common.ControllerTemplate;
import org.mushare.rate.controller.common.ErrorCode;
import org.mushare.rate.domain.Currency;
import org.mushare.rate.service.common.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/api/currencies")
public class CurrencyController extends ControllerTemplate {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity getCurrencies(@RequestParam(defaultValue = "en") String lan,
                                        @RequestParam(defaultValue = "0") final int rev) {
        final Result result = currencyManager.getCurrencies(rev, lan);
        if (!result.isSuccess()) {
            return generateBadRequest(ErrorCode.RevisionIllegal);
        }
        return generateOK(new HashMap<String, Object>(){{
            put("currencies", (List<Currency>) result.getData());
            put("revision", rev);
        }});
    }

}
