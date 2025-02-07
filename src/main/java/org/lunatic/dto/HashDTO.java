package org.lunatic.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class HashDTO {
    private String hash;
    private boolean used;
}


