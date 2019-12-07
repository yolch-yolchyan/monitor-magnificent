package com.task.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * implementation of sending log error notifications
 */
@Slf4j
@Service
public class LogNotificationSender implements NotificationSender {

    @Value("${magnificent.url}")
    private String magnificentUrl;

    @Override
    public void sendNotification() {
        log.error("magnificent is down. Take a look at: {} time: {}", magnificentUrl, LocalDateTime.now());
    }

}
