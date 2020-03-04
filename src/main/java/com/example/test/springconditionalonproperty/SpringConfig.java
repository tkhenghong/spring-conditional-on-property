package com.example.test.springconditionalonproperty;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// Tutorial link: https://www.roytuts.com/spring-conditionalonproperty-example/
@Configuration
public class SpringConfig {

    // NOTE: "If you do not configure the property in properties file and havingValue = "true" with matchIfMissing = true does not make sense."
    // Means if you're using havingValue = "true", that means your MUST need to have a property value in *.properties file with the correct property name with value "true".
    // BUT, you have added matchIfMissing = true. So no matter your *.properties file has the value or not, the FIRST and ONLY thing that Spring Boot cares is havingValue.
    // That's the reason why havingValue = "true" with matchIfMissing = true does not make sense

    @Bean
    // Scenario 1
//    @ConditionalOnProperty(prefix = "module", name = "enabled", matchIfMissing = true)
    // matchIfMissing defaults is false. So it means normally your *properties file MUST have this property value.
    // If matchIfMissing = true, but there's no module.enabled property --> Loaded successfully
    // If matchIfMissing = true, but module.enabled=true --> Loaded successfully
    // If matchIfMissing = true, but module.enabled=false --> Not loaded, found different value in property

    // Scenario 2:
//    @ConditionalOnProperty(prefix = "module", name = "enabled")
    // If there's no module.enabled property --> Not loaded, could not find property module.enabled
    // If module.enabled=true --> Loaded successfully
    // If module.enabled=false --> Not loaded, found different value in property

    // Scenario 3:
//    @ConditionalOnProperty(prefix = "module", name = "enabled", havingValue = "true")
    // If havingValue = false, but there's no module.enabled property --> Not loaded, could not find property module.enabled
    // If havingValue = false, but module.enabled=true --> Not loaded, found different value in property
    // If havingValue = false, but module.enabled=false --> Loaded successfully
    // If havingValue = true, but there's no module.enabled property --> Not loaded, could not find property module.enabled
    // If havingValue = true, but module.enabled=true --> Loaded successfully
    // If havingValue = true, but module.enabled=false --> Not loaded, found different value in property

    // Scenario 4:
//    @ConditionalOnProperty(prefix = "module", name = "enabled", havingValue = "true", matchIfMissing = true)
    // Assume matchIfMissing = true,
    // If havingValue = true, but there's no module.enabled property --> Loaded successfully
    // If havingValue = true, but module.enabled=true --> Loaded successfully
    // If havingValue = true, but module.enabled=false --> Not loaded, found different value in property

    // Dynamic values
    // Scenario 5:
//    @ConditionalOnProperty(prefix = "module", name = {"enabled", "dynamic"})
    // If module.enabled=true but no module.dynamic --> Not loaded, could not find property module.dynamic
    // If module.enabled=true but module.dynamic=true --> Loaded successfully
    // If module.enabled=true but module.dynamic=false --> Not loaded, found different value in property module.dynamic
    // If module.enabled=false but module.dynamic=true --> Not loaded, found different value in property module.enabled
    // If module.enabled=false but module.dynamic=false --> Not loaded, found different value in property module.enabled & module.dynamic

    // Scenario 6:
//    @ConditionalOnProperty(prefix = "module", name = {"enabled", "dynamic"}, havingValue = "true")
    // Assume havingValue = "true"
    // If module.enabled=true but module.dynamic=false --> Not loaded, found different value in property module.dynamic
    // If module.enabled=false but module.dynamic=true --> Not loaded, found different value in property module.enabled
    // If module.enabled=false but module.dynamic=false --> Not loaded, found different value in property module.enabled & module.dynamic

    @ConditionalOnProperty(prefix = "module", name = {"enabled", "dynamic"}, matchIfMissing = true)

    public SpringService springService() {
        return new SpringService();
    }
}
