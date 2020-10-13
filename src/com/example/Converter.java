package com.example;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;

public class Converter {

    private HashMap<String,Currency> currencyHashMap = new HashMap<>();

    public Converter() throws ParserConfigurationException, SAXException, IOException {
        var connection = new NBPConnection();
        this.currencyHashMap = connection.getExchangeRate();
    }

    public boolean checkIsSupported(String currency_code)
    {
        return !currencyHashMap.containsKey(currency_code);
    }


    public float exchange(String input_code, String output_code, float amount)
    {

        float input = currencyHashMap.get(input_code).getExchangeRate() /
                currencyHashMap.get(input_code).getRate();
        float output = currencyHashMap.get(output_code).getExchangeRate() /
                currencyHashMap.get(output_code).getRate();

        return amount * input/ output ;
    }


    public void dataValidation(String input_code, String output_code, float amount)
    {
        if(checkIsSupported(input_code) || checkIsSupported(output_code))
        {
            System.out.println("Wrong currency code!");

        }
        else if(amount <= 0)
        {
            System.out.println("Incorrect amount!");
        }
        else
        {
            System.out.println("This is your change: " + exchange(input_code,output_code, amount)
                    + output_code);
        }

    }

    public void hashMapPrint()
    {
        for (String keys : currencyHashMap.keySet())
        {
            System.out.println(keys + " : "+ currencyHashMap.get(keys).getExchangeRate());
        }
    }


}
