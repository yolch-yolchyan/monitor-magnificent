package com.task.scheduler;

import com.task.notification.NotificationSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class MagnificentStatusCheckScheduler {

    private final NotificationSender notificationSender;

    private final MagnificentStatusChecker magnificentStatusChecker;

    /**
     * scheduler which runs every 10 seconds to check if <b>magnificent</b> is down
     *
     * <p>
     *     if Magnificent is down, it will send a notification by using @see com.task.notification.NotificationSender,
     *     otherwise will not take any actions
     * </p>
     */
    @Scheduled(fixedDelay = 5000) // every 5 seconds
    public void checkStatusCron() {
        log.info("verifying magnificent status at: {}", LocalDateTime.now());

        if (magnificentStatusChecker.isMagnificentDown()) {
            log.info("magnificent is down at: {} and sending notification", LocalDateTime.now());

            notificationSender.sendNotification();
        }
    }

}
