package io.meksula.transformer.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class TransformationStatusService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${format-transformer-persister.scheme}")
    private String formatTransformerScheme;

    @Value("${FORMAT_TRANSFORMER_PERSISTER_HOST : ${format-transformer-persister.host}}")
    private String formatTransformerHost;

    @Value("${format-transformer-persister.port}")
    private String formatTransformerPort;

    @Value("${format-transformer-persister.get-stats}")
    private String formatTransformerGetStats;

    @PostConstruct
    public void describe() {
        log.info("formatTransformerHost: {}", this.formatTransformerHost);
    }

    StatisticsDto getDataFromFormatTransformer() {
        final String URL = formatTransformerScheme.concat(formatTransformerHost.concat(":").concat(formatTransformerPort).concat(formatTransformerGetStats));
        log.info("Request to: {}", URL);
        return restTemplate.getForEntity(URL, StatisticsDto.class).getBody();
    }
}
