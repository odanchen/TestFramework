package ca.canada.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigCache;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:cfg/run.properties", "system:env"})
public interface FrameworkConfig extends Config {
    static FrameworkConfig getConfig() {
        return ConfigCache.getOrCreate(FrameworkConfig.class, System.getProperties(), System.getenv());
    }

    @Key("IS_HEADLESS")
    @DefaultValue("false")
    Boolean isHeadless();

    @Key("BROWSER")
    @DefaultValue("Chrome")
    String getBrowser();
}
