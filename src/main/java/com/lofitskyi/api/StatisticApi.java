package com.lofitskyi.api;

import com.lofitskyi.entity.Currency;
import com.lofitskyi.entity.User;
import com.lofitskyi.services.CurrencyService;
import com.lofitskyi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/stat")
public class StatisticApi {

    private final UserService userService;
    private final CurrencyService currencyService;

    @Autowired
    public StatisticApi(UserService userService, CurrencyService currencyService) {
        this.userService = userService;
        this.currencyService = currencyService;
    }

    @RequestMapping(path = "/{currencyName}/{id}", method = GET)
    public BigDecimal getStatisticById(@PathVariable Long id,
                                      @PathVariable String currencyName){

        final User user = userService.getUserById(id);
        final Currency currency = currencyService.getCurrencyByName(currencyName);

        return user.getWastes().stream()
                .map(value -> value.multiply(currency.getRate()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
