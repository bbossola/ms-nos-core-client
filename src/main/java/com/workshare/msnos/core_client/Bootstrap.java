package com.workshare.msnos.core_client;

import com.workshare.msnos.core.Agent;
import com.workshare.msnos.core.Cloud;
import com.workshare.msnos.core.LocalAgent;

import java.io.IOException;
import java.util.UUID;

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
        cloud = new Cloud(new UUID(111, 222));
        agent = new LocalAgent(UUID.randomUUID());
    }

}
