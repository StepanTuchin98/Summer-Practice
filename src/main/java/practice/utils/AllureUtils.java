package practice.utils;

import com.codeborne.selenide.Screenshots;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;
import feign.Response;
import feign.Util;
import org.apache.commons.lang3.StringUtils;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class AllureUtils {

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveText(String attachmentName, String request) {
        return request;
    }

    public static <T> String getBodyAsString(Response response, T object) throws IOException {
        if (response.body() != null) {
            String body = StringUtils.EMPTY;
            body += response.status() + "\n";
            for (Map.Entry<String, Collection<String>> headers : response.headers().entrySet()) {
                body += headers.getKey() + StringUtils.SPACE;
                for (String value : headers.getValue()) {
                    body += value + StringUtils.SPACE;
                }
                body += "\n";
            }
            if (object != null) {
                ObjectMapper mapper = new ObjectMapper();
                body += mapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(object);

            } else {
                body += Util.toString(response.body().asReader());
            }
            return body;
        }
        return null;
    }

    @Attachment(value = "{1}", type = "image/png")
    public static byte[] allureScreenshot(int timeout, String name) throws IOException {
        WaiterUtils.wait(timeout);
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }
}