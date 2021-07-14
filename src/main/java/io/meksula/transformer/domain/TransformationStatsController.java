package io.meksula.transformer.domain;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/stats")
public class TransformationStatsController {

    private TransformationStatusService transformationStatusService;

    @GetMapping
    StatisticsDto getStatistics() {
        return transformationStatusService.getDataFromFormatTransformer();
    }
}
