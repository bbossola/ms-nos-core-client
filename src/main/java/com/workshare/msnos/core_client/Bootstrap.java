package com.workshare.msnos.core_client;

import java.io.IOException;
import java.util.UUID;

import com.workshare.msnos.core.Cloud;
import com.workshare.msnos.core.LocalAgent;
import com.workshare.msnos.core.security.KeysStore;
import com.workshare.msnos.core.security.Signer;

public class Bootstrap {

    private static Cloud cloud;
    private static LocalAgent microservice;

    public static Cloud grid() throws IOException {
        return cloud;
    }

    public static LocalAgent agent() throws IOException {
        return microservice;
    }

    public static void init() throws IOException {
        
        String signkey = getSecurityKey();
        if (signkey != null) {
            Console.out.println("ATTENTION! Using secured cloud");
            cloud = new Cloud(new UUID(111, 222), signkey);
        }
        else {
            Console.out.println("Using open cloud :)");
            cloud = new Cloud(new UUID(111, 222));
        }

        microservice = new LocalAgent(UUID.randomUUID());
    }

    private static String getSecurityKey() {
        String signkey = null;
        KeysStore keystore = Signer.DEFAULT_KEYSSTORE;
        if (!keystore.isEmpty()) {
            signkey = keystore.get("test");
        }
        return signkey;
    }

}
