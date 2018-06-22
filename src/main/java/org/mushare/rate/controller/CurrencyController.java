package org.mushare.rate.controller;

import org.mushare.rate.controller.common.ControllerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/currencies")
public class CurrencyController extends ControllerTemplate {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getCurrencies(String cid,
                                        @RequestParam(defaultValue = "en") String lan,
                                        @RequestParam(defaultValue = "0") int rev) {
        return null;
    }

}
