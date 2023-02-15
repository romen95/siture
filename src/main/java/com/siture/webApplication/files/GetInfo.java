package com.siture.webApplication.files;

import com.javastream.Client;
import com.javastream.entity.Contact;
import com.javastream.entity.ContactItem;
import com.javastream.entity.Deal;
import com.javastream.entity.model.Phone;
import com.javastream.service.DealService;
import com.javastream.utils.MultiFields;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class GetInfo {
    private final static String PREPARATION = "Подготовка документов";
    private final static String PREPAYMENT_INVOICE = "Счет на предоплату";
    private final static String EXECUTING = "В работе";

    public static Client client = new Client("b2j78p32fh1vknqs", "b24-n9gde9.bitrix24.ru", 1);

    public static List<Deal> getDealsList() {
        return client.dealService().getAll();
    }

    public static Contact getContactFromPhoneNumber(String phoneNumber) {
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



//    public static ArrayList<Integer> getContactsIdFromDealId(Integer dealId) {
//        List<ContactItem> contactItemsList = dealService.getContactFromDeal(dealId);
//        ArrayList<Integer> contactsIdList = new ArrayList<>();
//        for (ContactItem contactItemsElement : contactItemsList) {
//            contactsIdList.add(contactItemsElement.getContactId());
//        }
//        return contactsIdList;
//    }
//
//    public static Integer getContactIdFromDealId(Integer id) {
//        Integer result = dealService.getContactFromDeal(id).get(0).getContactId();
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
