import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors.*;
import static java.util.stream.Collectors.*;

class GraphAlgosDFS_BFS {

	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

	public static class Node {
		int id;
		LinkedList<Node> adjacent = new LinkedList<Node>();
		private Node(int id){
			this.id = id;
		}
	}
	
	private Node getNode(int id){
		return nodeLookUp.get(id);
	}
	
	public void addEdge(int source, int destination){
		Node s = getNode(source);
		Node d = getNode(destination);
		s.adjacent.add(d);
	}
	
	// Depth first Search
	public boolean hasPathDFS(int source, int destination){
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDFS(s, d, visited);
	}
	
	public boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited){
		
		if(visited.contains(source.id)){
			return false;
		}
		visited.add(source.id);
		
		if(source == destination){
			return true;
		}
		
		for(Node child : node.adjacent){
			if(hasPathDFS(child, destination, visited)) return true;
		}
		
		return false;
	}
	
	// BFS : Breadth First Search
	public boolean hasPathBFS(Node source, Node destination){
		
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		HashSet<Integer> visited = new HashSet<Integer>();
		nextToVisit.add(source);
		
		while(!nextToVisit.isEmpty()){
			Node node = nextToVisit.remove();
			if(node == destination){
				return true;
			}
			
			if(visited.contains(node.id)){
				continue;
			}
			visited.add(node.id);
			
			for(Node child : node.adjacent){
				nextToVisit.add(child);
			}
		}
		
		return false;
	}
 	
	public static void main(String[] args){
	
 	}
}