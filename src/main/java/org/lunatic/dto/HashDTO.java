package org.lunatic.dto;

import lombok.Builder;

@Builder
public class HashDTO {
    public final String hash;
    public final boolean isUsed;
}
