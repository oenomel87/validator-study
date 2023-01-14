package io.dane.validator.validator.rule;

import io.dane.validator.domain.Department;
import io.dane.validator.validator.ValidationRule;
import org.springframework.util.StringUtils;

public class CodeShouldeNotBeEmpty implements ValidationRule<Department> {

    @Override
    public String valid(Department department) {
        return StringUtils.hasText(department.getCode()) ? "" : "부서 코드를 입력하세요.";
    }
}
