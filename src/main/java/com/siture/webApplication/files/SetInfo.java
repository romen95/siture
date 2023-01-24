package com.siture.webApplication.files;

import com.javastream.Client;

public class SetInfo {
    private final static String PREPARATION = "Подготовка документов";
    private final static String PREPAYMENT_INVOICE = "Счет на предоплату";
    private final static String EXECUTING = "В работе";

    public String getInfo(Integer id) {
        Client client = new Client("6fcrhv0c1ezwn1gq", "b24-kkryjp.bitrix24.ru", 1);
        client.dealService().get(id);
        return "fdsf";
    }
}
