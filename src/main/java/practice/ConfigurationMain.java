package practice;

import practice.BE.ConfigurationFile;
import practice.FE.ConfigUI;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = {"practice.BE.steps",
        "practice.FE.steps", "practice.utils", "practice.FE.pages"})
@Import({ConfigUI.class, ConfigurationFile.class})
public class ConfigurationMain {
}
