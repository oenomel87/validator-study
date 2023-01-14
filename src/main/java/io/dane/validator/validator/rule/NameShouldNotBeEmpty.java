package io.dane.validator.validator.rule;

import io.dane.validator.domain.Department;
import io.dane.validator.validator.ValidationRule;
import org.springframework.util.StringUtils;

public class NameShouldNotBeEmpty implements ValidationRule<Department> {

    @Override
    public String valid(Department department) {
        return StringUtils.hasText(department.getName()) ? "" : "부서 명을 입력하세요.";
    }
}
