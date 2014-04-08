package com.workshare.msnos.core_client;

import java.io.IOException;
import java.util.UUID;

import com.workshare.msnos.core.Agent;
import com.workshare.msnos.core.Cloud;

public class Bootstrap {

    private static Cloud cloud;
    private static Agent agent;

    public static Cloud grid() throws IOException {
        return cloud;
    }

    public static Agent agent() throws IOException {
        return agent;
    }

    public static void init() throws IOException {
        cloud = new Cloud(new UUID(111, 222));
        agent = new Agent(UUID.randomUUID());
    }

}
