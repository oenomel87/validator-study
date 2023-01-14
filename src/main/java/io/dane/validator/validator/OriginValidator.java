package io.dane.validator.validator;

import io.dane.validator.data.HRData;
import io.dane.validator.domain.Department;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OriginValidator {

    public static List<String> valid(Department department) {
        var errors = new ArrayList<String>();

        if(!StringUtils.hasText(department.getName())) {
            errors.add("부서 명을 입력하세요.");
        }

        if(!StringUtils.hasText(department.getCode())) {
            errors.add("부서 코드를 입력하세요.");
        }

        if(!StringUtils.hasText(department.getDeptPathCode())) {
            errors.add("부서 경로를 입력하세요.");
        }

        if(!isValidDeptPathCode(department)) {
            errors.add("부서 경로가 유효하지 않습니다.");
        }

        return errors;
    }

    private static boolean isValidDeptPathCode(Department department) {
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
