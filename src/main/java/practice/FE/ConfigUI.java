package practice.FE;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigUI {

    @Value("${currentBrowser:firefox}")
    private String currentBrowser;

    @Value("${ui.address}")
    private String uiAddress;
}
