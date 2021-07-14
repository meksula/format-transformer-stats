package io.meksula.transformer.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class TransformationStatusService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${format-transformer}")
    private String formatTransformerUrl;

    @Value("${format-transformer-get-stats}")
    private String formatTransformerGetStats;

    StatisticsDto getDataFromFormatTransformer() {
        final String URL = formatTransformerUrl.concat(formatTransformerGetStats);
        log.info("Request to: {}", URL);
        return restTemplate.getForEntity(URL, StatisticsDto.class).getBody();
    }
}
