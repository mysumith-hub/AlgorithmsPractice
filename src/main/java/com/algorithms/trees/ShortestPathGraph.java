package com.algorithms.trees;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShortestPathGraph {

	public Map<String,LinkedList<GraphNode>> graphVerties = new LinkedHashMap<String,LinkedList<GraphNode>>();
//	public ShortestPathGraph(){
//		
//	}
	public void addEdge(String v, String u, int w){
		GraphNode grpahNode = new GraphNode(u, w);
		if(graphVerties.containsKey(v)){
			graphVerties.get(v).add(grpahNode);	
		}else{
			LinkedList<GraphNode> node = new LinkedList<GraphNode>();
			node.add(grpahNode);
			graphVerties.put(v, node);
		}
		GraphNode grpahNode1 = new GraphNode(v, w);
		if(graphVerties.containsKey(u)){
			graphVerties.get(u).add(grpahNode1);	
		}else{
			LinkedList<GraphNode> node = new LinkedList<GraphNode>();
			node.add(grpahNode1);
			graphVerties.put(u, node);
		}
	}
	public void traverse(){
		
	}
	public void findPath(String source){
		Map<String,Integer> distance = new LinkedHashMap<String, Integer>();
		Map<String,String> previousVertices = new LinkedHashMap<String, String>();
		Map<String,Boolean> visited = new LinkedHashMap<String, Boolean>();
		Iterator<String> iterator = graphVerties.keySet().iterator();
		while(iterator.hasNext()){
			distance.put(iterator.next(), Integer.MAX_VALUE);
		}
		Queue<String> queue = new LinkedList<String>();
		queue.add(source);
		distance.put(source,0);
		while(!queue.isEmpty()){
			String vertice = queue.remove();
			LinkedList<GraphNode> neighbours = graphVerties.get(vertice);
			Iterator<GraphNode> nodesIterator = neighbours.iterator();
			while(nodesIterator.hasNext()){
				GraphNode graphNode = nodesIterator.next();
				
				if(!visited.containsKey(graphNode.u)){
					queue.add(graphNode.u);	
					
					if(previousVertices.containsKey(vertice)){
						int minDist = distance.get(vertice)+graphNode.w;
						distance.put(graphNode.u, minDist);
					}else{
						int minDist = Math.min(distance.get(graphNode.u),graphNode.w);
						distance.put(graphNode.u, minDist);
						
					}
					previousVertices.put(graphNode.u,vertice);
				}	
			}
			visited.put(vertice, true);
			
		}
//		for(Map.Entry<String, LinkedList<GraphNode>> entries : graphVerties.entrySet()){
//			if(!visited.containsKey(entries.getKey())){
//				LinkedList<GraphNode> neighbours = graphVerties.get(entries.getKey());
//				Iterator<GraphNode> nodesIterator = neighbours.iterator();
//				while(nodesIterator.hasNext()){
//					GraphNode graphNode = nodesIterator.next();
//					
//					if(previousVertices.containsKey(graphNode.u)){
//						int minDist = distance.get(previousVertices.get(graphNode.u))+graphNode.w;
//						distance.put(graphNode.u, minDist);
//					}else{
//						int minDist = Math.min(distance.get(graphNode.u),graphNode.w);
//						distance.put(graphNode.u, minDist);
//						previousVertices.put(graphNode.u,entries.getKey());
//					}
//				}
//			}
//			visited.put(entries.getKey(), true);
//		}
		for(Map.Entry<String, Integer> entires : distance.entrySet()){
			System.out.println(entires.getKey()+":"+entires.getValue());
		}
	}
	public static void main(String args[]){
//		System.out.println(Integer.MAX_VALUE);
		ShortestPathGraph shortestPathGraph = new ShortestPathGraph();
		shortestPathGraph.addEdge("A", "B", 6);
		shortestPathGraph.addEdge("A", "D", 1);
		shortestPathGraph.addEdge("B", "C", 5);
		shortestPathGraph.addEdge("B", "E", 2);
		shortestPathGraph.addEdge("D", "E", 2);
		shortestPathGraph.addEdge("D", "B", 1);
		shortestPathGraph.addEdge("E", "C", 5);
		System.out.println(shortestPathGraph.graphVerties);
		shortestPathGraph.findPath("A");
	}
}
class GraphNode{
	public String u;
	public int w;
	GraphNode(String u,int w){
		this.u = u;
		this.w = w;
	}
	@Override
	public String toString() {
		return "GraphNode [\n\tu=" + u + ", \n\t\tw=" + w + "\n]";
	}
}
