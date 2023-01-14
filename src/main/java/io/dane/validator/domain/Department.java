package io.dane.validator.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    private String name;

    private String code;

    private String deptPathName;

    private String deptPathCode;
}
