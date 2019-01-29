package util;

import java.util.concurrent.atomic.AtomicBoolean;


public class TestHandler  {


    private static final AtomicBoolean initialized = new AtomicBoolean();

    public static AtomicBoolean getInitializedStatus() {
        return initialized;
    }


}
