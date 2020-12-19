package org.example;

import io.micronaut.context.annotation.Factory;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.elasticsearch.ElasticsearchLockProvider;
import org.elasticsearch.client.RestHighLevelClient;

import javax.inject.Singleton;

@Factory
public class SchedulingLockConfiguration {

    @Singleton
    LockProvider lockProvider(RestHighLevelClient client) {
        return new ElasticsearchLockProvider(client);
    }
}
