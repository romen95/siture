package com.siture.webApplication.files;

import com.javastream.Client;
import com.javastream.entity.Contact;
import com.javastream.entity.ContactItem;
import com.javastream.entity.Deal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
@Slf4j
public class BitrixService {
    private final String PREPARATION = "Подготовка документов";
    private final String PREPAYMENT_INVOICE = "Счет на предоплату";
    private final String EXECUTING = "В работе";

    private Client client = new Client("b2j78p32fh1vknqs", "b24-n9gde9.bitrix24.ru", 1);

    private List<Deal> getDealsList() {
        return client.dealService().getAll();
    }

    public Contact getContactFromPhoneNumber(String phoneNumber) {
        Contact contact = null;
        List<Contact> contacts = client.contactService().getAll();
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            Contact currentContact = contacts.get(i);
            try {
                if (currentContact.getPhones().get(0).getValue().equals(phoneNumber)) {
                    contact = currentContact;
                }
            } catch (NullPointerException e) {

            }
        }
        return contact;
    }

//    public ArrayList<Deal> getDealsArrayFromPhoneNumber(String phoneNumber) {
//        List<Deal> allDeals = getDealsList();
//        log.info("Количество сделок: {}", allDeals.size());
//        ArrayList<Deal> resultDeals = new ArrayList<>();
//        for (int i = 0; i < allDeals.size(); i++) {
//            List<ContactItem> contactItems = client.dealService().getContactFromDeal(allDeals.get(i).getId());
//            for (int j = 0; j < contactItems.size(); j++) {
//                if (contactItems.get(j).getContactId().equals(getContactFromPhoneNumber(phoneNumber).getId())) {
//                    resultDeals.add(allDeals.get(i));
//                }
//            }
//        }
//        log.info("Количество сделок: {}", resultDeals.size());
//        return resultDeals;
//    }



//    private ArrayList<Integer> getContactsIdsFromDealId(Integer dealId) {
//        List<ContactItem> contactItemsList = client.dealService().getContactFromDeal(dealId);
//        ArrayList<Integer> contactsIdsList = new ArrayList<>();
//        for (ContactItem contactItemsElement : contactItemsList) {
//            contactsIdsList.add(contactItemsElement.getContactId());
//        }
//        return contactsIdsList;
//    }
//
//    public Integer getContactIdFromDealId(Integer id) {
//        Integer result = client.dealService().getContactFromDeal(id).get(0).getContactId();
//        return result;
//    }
//
//    public static String getDealStageByDealId(Integer id) {
//        String stageId = "";
//        String stage = "";
//        try {
//            stageId = dealService.get(id).getStageId();
//        } catch (NullPointerException e) {
//            return stage = null;
//        }
//        switch (stageId) {
//            case "PREPARATION" :
//                stage = PREPARATION;
//                break;
//            case "PREPAYMENT_INVOICE" :
//                stage = PREPAYMENT_INVOICE;
//                break;
//            case "EXECUTING" :
//                stage = EXECUTING;
//                break;
//            default:
//                stage = "Статус не известен";
//        }
//        return stage;
//    }
//
//    public static String getDealStageByClientId(Integer clientId) {
//        String dealStage = "";
//        Integer resultDealId = null;
//        List<Deal> dealList = getDealsList();
//        ArrayList<Integer> contactsId = new ArrayList<>();
//        for (int i = 0; i < dealList.size(); i++) {
//            int currentDealId = dealList.get(i).getId();
//            contactsId = getContactsIdFromDealId(currentDealId);
//            for (int j = 0; j < contactsId.size(); j++) {
//                Integer currentContactId = contactsId.get(j);
//                if (currentContactId.equals(clientId)) {
//                    resultDealId = currentDealId;
//                }
//            }
//        }
//        dealStage = getDealStageByDealId(resultDealId);
//        return dealStage;
//    }
}
