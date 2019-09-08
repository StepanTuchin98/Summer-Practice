package practice.BE.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeResponseUpdateCreate {
    private Integer id;
    private String name;
    private Integer salary;
    private Integer age;

    public EmployeeResponse toEmployeeResponse (){
        return new EmployeeResponse(this.id, this.name, this.salary, this.age);
    }
}
