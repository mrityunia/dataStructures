package com.smartcity.transport.interfaces;

public interface Connectable {
    void connectToNetwork(String networkName);
    void disconnect();
}
