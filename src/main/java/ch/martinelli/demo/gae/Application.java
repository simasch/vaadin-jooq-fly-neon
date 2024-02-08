package ch.martinelli.demo.gae;

import ch.martinelli.demo.gae.db.tables.records.PersonRecord;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(Application.Hints.class)
@SpringBootApplication
@Theme(value = "appenginedemo")
@PWA(name = "AppEngineDemo", shortName = "AppEngineDemo", offlineResources = {})
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public static class Hints implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.resources().registerPattern("db/migration/*");
            hints.reflection().registerType(PersonRecord.class, MemberCategory.values());
        }
    }
}
