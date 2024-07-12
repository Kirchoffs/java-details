package org.syh.builder;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

@Builder
@ToString
public class GreekAlphabet {
    @NonNull
    private Integer alpha;
    @NonNull
    private Integer beta;
    @NonNull
    private Integer gamma;
    @NonNull
    private Integer delta;
    @NonNull
    private Integer epsilon;
}
