package io.meksula.transformer.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class TransformationStatusService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${format-transformer.scheme}")
    private String formatTransformerScheme;

    @Value("${format-transformer.host}")
    private String formatTransformerHost;

    @Value("${format-transformer.port}")
    private String formatTransformerPort;

    @Value("${format-transformer.get-stats}")
    private String formatTransformerGetStats;

    StatisticsDto getDataFromFormatTransformer() {
        final String URL = formatTransformerScheme.concat(formatTransformerHost.concat(":").concat(formatTransformerPort).concat(formatTransformerGetStats));
        log.info("Request to: {}", URL);
        return restTemplate.getForEntity(URL, StatisticsDto.class).getBody();
    }
}
