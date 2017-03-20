package com.lofitskyi.services;

import com.lofitskyi.entity.Currency;

public interface CurrencyService {
    Currency getCurrencyByName(String currencyName);
}
