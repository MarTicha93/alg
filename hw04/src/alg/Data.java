package alg;

import java.util.ArrayList;
import java.util.Collection;

public class Data {
    private final int countOfAllServers;
    private final int countOfKeyServers;

    private final ArrayList<Collection<EdgePair>> adjacencyList;
    private final Collection<Integer> keyServers;

    public Data(int countOfAllServers, int countOfKeyServers, ArrayList<Collection<EdgePair>> adjacencyList, Collection<Integer> keyServers) {
        this.countOfAllServers = countOfAllServers;
        this.countOfKeyServers = countOfKeyServers;
        this.adjacencyList = adjacencyList;
        this.keyServers = keyServers;
    }

    public int getCountOfAllServers() {
        return countOfAllServers;
    }

    public int getCountOfKeyServers() {
        return countOfKeyServers;
    }

    public ArrayList<Collection<EdgePair>> getAdjacencyList() {
        return adjacencyList;
    }

    public Collection<Integer> getKeyServers() {
        return keyServers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(countOfAllServers).append(" ").append(countOfKeyServers).append("\n");
        for (int i = 0; i < adjacencyList.size(); i++) {
            sb.append(i).append(" - ");
            for (EdgePair edge : adjacencyList.get(i)) {
                sb.append(" [").append(edge.getEndNode()).append(", ").append(edge.getPrice()).append("] ");
            }
            sb.append("\n");
        }
        for (int keyServer : keyServers) {
            sb.append(keyServer).append(" ");
        }
        sb.append("\n");

        return sb.toString();
    }
}

