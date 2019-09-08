package practice.BE.clients;

import practice.BE.models.EmployeeRequest;
import feign.*;
import practice.BE.models.EmployeeRequestUpdateCreate;

public interface EmployeeClient {

    @RequestLine("GET /api/v1/employees")
    @Headers({"Content-Type: application/json"})
    Response getAllEmployee();

    @RequestLine("GET /api/v1/employee/{id}")
    @Headers({"Content-Type: application/json"})
    Response getSingleEmployee(@Param("id") Integer id);

    @RequestLine("POST /api/v1/create")
    @Headers({"Content-Type: application/json"})
    Response createEmployee(EmployeeRequestUpdateCreate employee);

    @RequestLine("PUT /api/v1/update/{id} ")
    @Headers({"Content-Type: application/json"})
    Response updateEmployee(@Param("id") Integer id, EmployeeRequestUpdateCreate employee);

    @RequestLine("DELETE /api/v1/delete/{id} ")
    @Headers({"Content-Type: application/json"})
    Response deleteEmployee(@Param("id") Integer id);
}