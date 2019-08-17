package properties;

import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class JPAProperties extends Properties {
    public JPAProperties() {
        this.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        this.put("hibernate.show_sql", true);
        this.put("hibernate.hbm2ddl.auto", "create");
    }
}
