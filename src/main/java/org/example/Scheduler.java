package org.example;

import io.micronaut.scheduling.annotation.Scheduled;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.micronaut.SchedulerLock;

import javax.inject.Singleton;

import static net.javacrumbs.shedlock.core.LockAssert.assertLocked;

@Slf4j
@Singleton
public class Scheduler {

    @Scheduled(fixedDelay = "5s")
    @SchedulerLock(name = "say-hello-scheduler")
    void schedule() {
        assertLocked();
        log.info("Hello from {}", App.class.getName());
    }
}
