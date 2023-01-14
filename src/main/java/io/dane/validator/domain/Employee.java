package io.dane.validator.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    private String name;

    private String code;

    private String ldap;

    private String job;

    private List<Position> positions;
}
