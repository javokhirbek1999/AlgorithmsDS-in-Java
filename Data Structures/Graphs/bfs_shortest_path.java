import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

class Graph{
    Map<String,ArrayList<String>> gdict = new LinkedHashMap<>();
    public Graph(Map<String,ArrayList<String>> gdict){
        this.gdict = gdict;
    }

    public void addEdge(String vertex, String edge){
        this.gdict.get(vertex).add(edge);
    }

    public ArrayList<String> bfs_shortest_path(String start, String end){
        ArrayList<ArrayList<String>>queue = new ArrayList<>();
        ArrayList<String> n = new ArrayList<>();
        n.add(start);
        ArrayList<ArrayList<String>> directions = new ArrayList<>();
        queue.add(n);
        while(queue.size()>0){
            ArrayList<String> path = queue.get(0);
            queue.remove(0);
            String node = path.get(path.size()-1);
            if(node==end){
                System.out.println("Avaiable directions: ");
                for(int i = 0; i<directions.size(); i++){
                    if(directions.get(i).get(0).equals(start) && directions.get(i).get(directions.get(i).size()-1)==end){
                        System.out.println(directions.get(i));
                    }
                    }
                    System.out.println("Shortest directions: ");
                    return path;
                }
                for(int i = 0; i<this.gdict.get(node).size(); i++){
                    ArrayList<String> new_path = new ArrayList<>(path);
                    new_path.add(this.gdict.get(node).get(i));
                    queue.add(new_path);
                    directions.add(new_path);
                }
            }
            return null;
        }
    }
