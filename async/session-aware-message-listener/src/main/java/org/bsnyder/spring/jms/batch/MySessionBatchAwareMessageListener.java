package org.bsnyder.spring.jms.batch;

import javax.jms.*;
import java.util.Date;
import java.util.List;

import org.bsnyder.spring.jms.listener.MySessionAwareMessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jms.Message;

public class MySessionBatchAwareMessageListener implements SessionAwareBatchMessageListener<Message>{

    private static final Logger LOG = LoggerFactory.getLogger(MySessionBatchAwareMessageListener.class);

    @Override
    public void onMessages(Session session, List<Message> messages) throws JMSException {
        for (Message message : messages) {
            //String message = (String)om.getObject();
            //StringBuilder buffer = new StringBuilder("Reply message sent at: ").append(new Date());
            //System.out.println("Message got from:- " +message);
            LOG.info("Message got from:- " +((TextMessage)message).getText());
        }
    }
}
