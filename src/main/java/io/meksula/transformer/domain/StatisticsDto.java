package io.meksula.transformer.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class StatisticsDto {
    private Long totalRecords;
    private Long totalRecordsToday;
    private LocalDateTime oldestRecordDate;
    private LocalDateTime newestRecordDate;
    private Set<String> hostnames;
    private Set<TransformerDto> records;
}
