package com.lofitskyi.services;

import com.lofitskyi.entity.Currency;
import com.lofitskyi.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository repository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Currency getCurrencyByName(String currencyName) {
        return repository.findByName(currencyName);
    }
}
