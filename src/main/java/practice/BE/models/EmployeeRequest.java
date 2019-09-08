package practice.BE.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private String employee_name;
    private Integer employee_salary;
    private Integer employee_age;
}
