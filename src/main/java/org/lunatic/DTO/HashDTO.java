package org.lunatic.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class HashDTO {
    public final String hash;
    public final boolean isUsed;
}
