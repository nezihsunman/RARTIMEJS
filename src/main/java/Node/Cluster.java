package main.java.Node;

import java.util.ArrayList;

//Singleton Cluster for having a reference to the available nodes in the system.
public class Cluster {
    private static Cluster instance;
    private ArrayList<Node> cluster = null;


    private Cluster() {
        this.cluster = new ArrayList<Node>();
    }

    public synchronized static Cluster getSingletonInstance() {
        if (null == instance) {
            instance = new Cluster();
        }
        return instance;
    }

    public ArrayList<Node> getCluster() {
        return this.cluster;
    }

    public Node getAvailableNode() {
        for (Node node : cluster) {
            if (node.checkAvailable()) {
                return node;
            }
        }
        System.out.println("No Node avaliable");
        return null;
    }

    public void registerNode(Node n) {
        cluster.add(n);
    }
}
