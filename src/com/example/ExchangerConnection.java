package com.example;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;

public interface ExchangerConnection {

    public HashMap<String, Currency> getExchangeRate() throws IOException, SAXException, ParserConfigurationException;



}
