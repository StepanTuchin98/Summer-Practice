package practice.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ObjMapper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T body2Object(Response response, Class<T> currentClass) throws IOException {
        return objectMapper.readValue(Util.toString(response.body().asReader()), currentClass);
    }

    public <T> String objest2Json(T object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }
}
