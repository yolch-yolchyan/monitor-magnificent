package com.task.scheduler;

import com.task.notification.NotificationSender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MagnificentStatusCheckSchedulerTest {

    @Mock
    private NotificationSender notificationSender;

    @Mock
    private MagnificentStatusChecker magnificentStatusChecker;

    @InjectMocks
    private MagnificentStatusCheckScheduler magnificentStatusCheckScheduler;

    @Test
    public void test_magnificentUp() {
        when(magnificentStatusChecker.isMagnificentDown()).thenReturn(false);

        magnificentStatusCheckScheduler.checkStatusCron();

        verifyNoMoreInteractions(notificationSender);
    }

    @Test
    public void test_magnificentDown() {
        when(magnificentStatusChecker.isMagnificentDown()).thenReturn(true);

        magnificentStatusCheckScheduler.checkStatusCron();

        verify(notificationSender).sendNotification();
    }

}
