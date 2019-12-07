package com.task.notification;

/**
 * <p>
 * this interface is designed as base for sending notification.
 * </p>
 *
 * <p>
 * it can have multiple implementations, and if we want to change
 * the way that notifications are sent, we just need to annotate
 * with @see org.springframework.stereotype.Service annotation the class
 * which implementation have to be used. For example, we could change to email notification sender or log notification sender
 * </p>
 */
public interface NotificationSender {

    /**
     * method to send notification
     *
     * whom should be sent will be loaded from properties
     */
    void sendNotification();

}
