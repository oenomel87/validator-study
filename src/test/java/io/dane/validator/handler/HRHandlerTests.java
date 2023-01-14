package io.dane.validator.handler;

import io.dane.validator.data.HRData;
import io.dane.validator.domain.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HRHandlerTests {

    @Autowired
    private HRHandler handler;

    @Test
    void simpleTest() throws Exception {
        var d = Department.builder()
                .name("d1")
                .code("d1")
                .deptPathCode("d1")
                .build();
        var data = HRData.getInstance();
        handler.addDepartment(d);
        assertThat(data.findAllDepartments()).anyMatch(dept -> dept.getCode().equals(d.getCode()));
    }

    @Test
    void simpleTestShouldThrowException() {
        var d = Department.builder()
                .name("d1")
                .build();
        assertThatThrownBy(() -> handler.addDepartment(d))
                .isExactlyInstanceOf(Exception.class);
    }
}