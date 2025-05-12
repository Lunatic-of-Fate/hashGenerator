package org.lunatic.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class HashDTO {
    public String hash;
    public boolean isUsed;
}


