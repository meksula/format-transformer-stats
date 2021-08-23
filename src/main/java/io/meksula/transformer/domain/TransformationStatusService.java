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

    @Value("${FORMAT_TRANSFORMER_PERSISTER_HOST}")
    private String formatTransformerHost;

    @Value("${FORMAT_TRANSFORMER_PERSISTER_PORT}")
    private String formatTransformerPort;

    @Value("${format-transformer-persister.get-stats}")
    private String formatTransformerGetStats;

    private String url;

    @PostConstruct
    public void describe() {
        log.info("formatTransformerHost: {}", this.formatTransformerHost);
        if (this.formatTransformerPort != null && !this.formatTransformerPort.isEmpty() && !this.formatTransformerPort.endsWith(":")) {
            this.formatTransformerPort = ":".concat(this.formatTransformerPort);
        } else {
            this.formatTransformerPort = "";
        }
        this.url = formatTransformerScheme.concat(formatTransformerHost.concat(formatTransformerPort).concat(formatTransformerGetStats));
    }

    StatisticsDto getDataFromFormatTransformer() {
        log.info("Request to: {}", this.url);
        return restTemplate.getForEntity(this.url, StatisticsDto.class).getBody();
    }
}
