package io.meksula.transformer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransformerDto {
    private TransformerTypes from;
    private TransformerTypes to;
    private String encodedData;
    private String hostname;
}
