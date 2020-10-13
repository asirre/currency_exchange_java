package com.example;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;

public class NBPConnection implements ExchangerConnection {

    @Override
    public HashMap<String, Currency> getExchangeRate() throws IOException, SAXException, ParserConfigurationException {
        HashMap<String,Currency> currencyHashMap = new HashMap<>();


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse("https://www.nbp.pl/kursy/xml/lasta.xml");

        Element root = doc.getDocumentElement();

        NodeList nList = doc.getElementsByTagName("pozycja");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                String nazwa_waluty = eElement
                        .getElementsByTagName("nazwa_waluty")
                        .item(0)
                        .getTextContent();
                String przelicznik = eElement
                        .getElementsByTagName("przelicznik")
                        .item(0)
                        .getTextContent();
                String kod_waluty = eElement
                        .getElementsByTagName("kod_waluty")
                        .item(0)
                        .getTextContent();
                String kurs_sredni = eElement
                        .getElementsByTagName("kurs_sredni")
                        .item(0)
                        .getTextContent();

                kurs_sredni = kurs_sredni.replace(",",".");


                Currency currency = new Currency(nazwa_waluty,Integer.parseInt(przelicznik),kod_waluty,Float.parseFloat(kurs_sredni));
                currencyHashMap.put(kod_waluty,currency);


            }
        }


    return currencyHashMap;
    }


}
