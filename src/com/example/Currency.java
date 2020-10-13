package com.example;

public class Currency {
    private String name;
    private Integer rate;
    private String code;
    private float exchange_rate;

    public Currency(String name, Integer rate, String code, float exchange_rate)
    {
        this.name = name;
        this.rate = rate;
        this.code = code;
        this.exchange_rate = exchange_rate;
    }

    public Integer getRate()
    {
        return rate;
    }

    public float getExchangeRate()
    {
        return exchange_rate;
    }

    public String getCode()
    {
        return code;
    }
}
