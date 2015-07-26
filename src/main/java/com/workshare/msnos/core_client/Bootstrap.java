package com.workshare.msnos.core_client;

import java.io.IOException;
import java.util.UUID;

import com.workshare.msnos.core.Cloud;
import com.workshare.msnos.core.LocalAgent;
import com.workshare.msnos.core.security.KeysStore;
import com.workshare.msnos.core.security.Signer;

public class Bootstrap {

    private static Cloud cloud;
    private static LocalAgent agent;

    public static Cloud grid() throws IOException {
        return cloud;
    }

    public static LocalAgent agent() throws IOException {
        return agent;
    }

    public static void init() throws IOException {
        
        String signid = getSecurityId();
        if (signid != null) {
            SysConsole.out.println("ATTENTION! Using secured cloud by id '"+signid+"'");
            cloud = new Cloud(new UUID(111, 222), signid);
        }
        else {
            SysConsole.out.println("Using open cloud :)");
            cloud = new Cloud(new UUID(111, 222));
        }

        agent = new LocalAgent(UUID.randomUUID());
    }

    private static String getSecurityId() {
        String res = null;
        KeysStore keystore = Signer.DEFAULT_KEYSSTORE;
        if (!keystore.isEmpty()) {
            if (keystore.get("test") != null)
                res = "test";
        }

        return res;
    }

}
