package util;

import java.util.concurrent.atomic.AtomicBoolean;


public class TestHandler  {

    private static final AtomicBoolean initialized = new AtomicBoolean();
    private static final AtomicBoolean enableFlag = new AtomicBoolean();
    private static final AtomicBoolean currentCacheEnabled = new AtomicBoolean();


    public static AtomicBoolean getInitializedStatus() { return initialized; }

    public static AtomicBoolean currentCacheDisabled() {
        return currentCacheEnabled;
    }

    public static AtomicBoolean testTypeEnabledCached() { return enableFlag; }

}
