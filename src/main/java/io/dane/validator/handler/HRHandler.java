package io.dane.validator.handler;

import io.dane.validator.data.HRData;
import io.dane.validator.domain.Department;
import io.dane.validator.validator.ValidationBuilder;
import io.dane.validator.validator.rule.CodeShouldeNotBeEmpty;
import io.dane.validator.validator.rule.NameShouldNotBeEmpty;
import io.dane.validator.validator.rule.PathCodeValidity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class HRHandler {

    @Autowired
    private PathCodeValidity pathCodeValidity;

    public void addDepartment(Department department) throws Exception {
        var validator = ValidationBuilder.<Department>builder()
                .apply(new NameShouldNotBeEmpty())
                .apply(new CodeShouldeNotBeEmpty())
                .apply(this.pathCodeValidity);
        var results = validator.checkRules(department);

        if(!CollectionUtils.isEmpty(results)) {
            throw new Exception("부서를 추가할 수 없습니다.");
        }

        HRData.getInstance().save(department);
    }
}
