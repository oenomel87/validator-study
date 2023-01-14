package io.dane.validator.validator.rule;

import io.dane.validator.data.HRData;
import io.dane.validator.domain.Department;
import io.dane.validator.validator.ValidationRule;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PathCodeValidity implements ValidationRule<Department> {

    @Override
    public String valid(Department department) {
        return StringUtils.hasText(department.getDeptPathCode()) && this.isValidDeptPathCode(department)
                ? ""
                    : "부서 경로가 유효하지 않습니다.";
    }

    private boolean isValidDeptPathCode(Department department) {
        var paths = department.getDeptPathCode().split(";");
        var data = HRData.getInstance();
        var departments = data.findAllDepartments();

        for(var path : paths) {
            if(path.equals(department.getCode())) {
                continue;
            }

            if(departments.stream().noneMatch(d -> d.getCode().equals(path))) {
                return false;
            }
        }

        return true;
    }
}
