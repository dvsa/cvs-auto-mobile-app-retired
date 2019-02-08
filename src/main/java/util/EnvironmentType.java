package util;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnvironmentType {

    LOCAL_REAL_DEVICE("localRealDevice"),
    LOCAL_BROWSERSTACK("localBrowserstack"),
    LOCAL_SIMULATOR("localSimulator"),
    CI_BROWSERSTACK("CI");

    private static final Map<String,EnvironmentType> ENUM_MAP;

    private String  envType;

    EnvironmentType(String envType) {
        this.envType = envType;
    }

    public String getEnvType() {
        return envType;
    }

    static {
        Map<String,EnvironmentType> map = new ConcurrentHashMap<>();
        for (EnvironmentType instance : EnvironmentType.values()) {
            map.put(instance.getEnvType(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static EnvironmentType get(String name) {
        return ENUM_MAP.get(name);
    }
}
