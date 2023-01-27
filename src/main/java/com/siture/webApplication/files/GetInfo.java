package com.siture.webApplication.files;

import com.javastream.Client;
import com.javastream.entity.Contact;
import com.javastream.entity.ContactItem;
import com.javastream.entity.Deal;
import com.javastream.service.DealService;

import java.util.ArrayList;
import java.util.List;

public class GetInfo {
    private final static String PREPARATION = "Подготовка документов";
    private final static String PREPAYMENT_INVOICE = "Счет на предоплату";
    private final static String EXECUTING = "В работе";

    public static Client client = new Client("6fcrhv0c1ezwn1gq", "b24-kkryjp.bitrix24.ru", 1);
    public static DealService dealService = client.dealService();

    public static List<Deal> getDealsList() {
        return dealService.getAll();
    }

    public static ArrayList<Integer> getContactsIdFromDealId(Integer dealId) {
        List<ContactItem> contactItemsList = dealService.getContactFromDeal(dealId);
        ArrayList<Integer> contactsIdList = new ArrayList<>();
        for (ContactItem contactItemsElement : contactItemsList) {
            contactsIdList.add(contactItemsElement.getContactId());
        }
        return contactsIdList;
    }

    public static Integer getContactIdFromDealId(Integer id) {
        Integer result = dealService.getContactFromDeal(id).get(0).getContactId();
        return result;
    }

    public static String getDealStageByDealId(Integer id) {
        String stageId = "";
        String stage = "";
        try {
            stageId = dealService.get(id).getStageId();
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
                stage = EXECUTING;
                break;
            default:
                stage = "Статус не известен";
        }
        return stage;
    }

    public static String getDealStageByClientId(Integer clientId) {
        String dealStage = "";
        Integer resultDealId = null;
        List<Deal> dealList = getDealsList();
        ArrayList<Integer> contactsId = new ArrayList<>();
        for (int i = 0; i < dealList.size(); i++) {
            int currentDealId = dealList.get(i).getId();
            contactsId = getContactsIdFromDealId(currentDealId);
            for (int j = 0; j < contactsId.size(); j++) {
                Integer currentContactId = contactsId.get(j);
                if (currentContactId.equals(clientId)) {
                    resultDealId = currentDealId;
                }
            }
        }
        dealStage = getDealStageByDealId(resultDealId);
        return dealStage;
    }
}
