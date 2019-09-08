package practice.BE.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestUpdateCreate {
    private String name;
    private Integer salary;
    private Integer age;
}
