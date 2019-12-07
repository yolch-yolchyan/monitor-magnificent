package com.task.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@Component
public class MagnificentStatusChecker {

    @Value("${magnificent.url}")
    private String magnificentUrl;

    public boolean isMagnificentDown() {
        HttpGet request = new HttpGet(magnificentUrl);
        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            return entity != null && !Objects.equals(EntityUtils.toString(entity), "Magnificent!");
        } catch (IOException e) {
            log.warn("error calling magnificent, marks magnificent down");

            return true;
        }
    }

}
