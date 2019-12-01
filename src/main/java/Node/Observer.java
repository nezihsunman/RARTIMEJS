package main.java.Node;

public interface Observer {
    void onObservableChanged(Node n) throws InterruptedException;
}
