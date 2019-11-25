package main.java.Node;

import main.java.Jobs.AbstractJob;

public interface Observer {
    void update(AbstractJob job);
}
