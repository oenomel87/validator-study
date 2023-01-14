package io.dane.validator.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Position {

    private Employee employee;

    private Department department;
}
