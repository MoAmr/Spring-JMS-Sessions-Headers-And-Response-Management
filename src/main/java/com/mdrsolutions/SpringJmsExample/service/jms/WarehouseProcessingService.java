package com.mdrsolutions.SpringJmsExample.service.jms;

import com.mdrsolutions.SpringJmsExample.pojos.BookOrder;
import com.mdrsolutions.SpringJmsExample.pojos.ProcessedBookOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class WarehouseProcessingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseProcessingService.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Transactional
    public ProcessedBookOrder processOrder(BookOrder bookOrder, String orderState, String storeId) {

        if ("NEW".equalsIgnoreCase(orderState)) {
            return add(bookOrder, storeId);
        } else if ("UPDATE".equalsIgnoreCase(orderState)) {
            return update(bookOrder, storeId);
        } else if ("DELETE".equalsIgnoreCase(orderState)) {
            return delete(bookOrder, storeId);
        } else {
            throw new IllegalArgumentException("warehouseProcessingService." +
                    "processOrder(...) - orderState did not match expected values");
        }
    }

    private ProcessedBookOrder add(BookOrder bookOrder, String storeId) {
        LOGGER.info("ADDING A NEW ORDER TO THE DB!");
        //TODO - do some type of DB operation
        return new ProcessedBookOrder(
                bookOrder,
                new Date(),
                new Date()
        );
    }

    private ProcessedBookOrder update(BookOrder bookOrder, String storeId) {
        LOGGER.info("UPDATING AN ORDER TO DB");
        //TODO - do some type of DB operation
        return new ProcessedBookOrder(
                bookOrder,
                new Date(),
                new Date()
        );
    }

    private ProcessedBookOrder delete(BookOrder bookOrder, String storeId) {
        LOGGER.info("DELETING THE ORDER FROM THE DB");
        //TODO - do some type of DB operation
        return new ProcessedBookOrder(
                bookOrder,
                new Date(),
                null
        );
    }
}
