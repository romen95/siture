package com.siture.webApplication.files;

import com.javastream.Client;
import com.javastream.entity.Contact;
import com.javastream.entity.ContactItem;
import com.javastream.entity.Deal;

import java.util.ArrayList;
import java.util.List;

public class GetInfo {
    private final static String PREPARATION = "Подготовка документов";
    private final static String PREPAYMENT_INVOICE = "Счет на предоплату";
    private final static String EXECUTING = "В работе";

    static Client client = new Client("6fcrhv0c1ezwn1gq", "b24-kkryjp.bitrix24.ru", 1);

    public static List<Deal> getDealsList() {
        return client.dealService().getAll();
    }

    public static Integer getContactIdFromDealId(Integer id) {
        Integer result = client.dealService().getContactFromDeal(id).get(0).getContactId();
        return result;
    }

    public static String getDealStageById(Integer id) {
        String stageId = "";
        String stage = "";
        try {
            stageId = client.dealService().get(id).getStageId();
        } catch (NullPointerException e) {
            return stage = null;
        }
        switch (stageId) {
            case "PREPARATION" :
                stage = PREPARATION;
                break;
            case "PREPAYMENT_INVOICE" :
                stage = PREPAYMENT_INVOICE;
                break;
            case "EXECUTING" :
                stage = PREPAYMENT_INVOICE;
                break;
            default:
                stage = "Статус не известен";
        }
        return stage;
    }
}
