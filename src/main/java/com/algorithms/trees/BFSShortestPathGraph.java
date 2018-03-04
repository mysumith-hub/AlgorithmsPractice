package com.algorithms.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import com.algorithms.ds.Graph;

public class BFSShortestPathGraph {

	public static TestGraph constructGraph()
	{		
		int noOfVertices,noOfEdges;
		TestGraph graph=null;

		int u, v;
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			noOfVertices=scanner.nextInt();
			noOfEdges=scanner.nextInt();


			graph=new TestGraph(noOfVertices);
			for(int i=0;i<noOfEdges;i++)
			{
				
				u=scanner.nextInt();
				v=scanner.nextInt();
				graph.addEdge(u, v);
				graph.addEdge(v, u);
			}
			break;
		}
		//graph.printGraph();
		return graph;
	}

	/**
	 * doBFSShortestPath(G, s, t):
	 * 	L <- Empty
	 *  visited <- Empty
	 *  Q <- Empty
	 *  S <- Empty
	 *  
	 *  Q <- add(Q, s)
	 *  S <- add(S, s)
	 *  visited[s] <- true
	 *  while(!Empty(Q))
	 *  	u <- poll(Q)
	 *  	for each vertex v in Adj[u]
	 *  		if visited[v]!=true
	 *  			Q <- add(Q,v)
	 *  			S <- add(S,v)
	 *  			visited[v] = true
	 *  			if u == dest
	 *  				break
	 *  currentSrc=t
	 *  L <- add(L,t)
	 *  while(!Empty(S))
	 *  	u <= poll(S)
	 *  	if isNeighbor(G,currentSrc,u)
	 *  		L <- add(L, u)
	 *  		currentSrc = node;
	 *  		if node == source
	 *  			break;
	 *  return L
	 *  		
	 * 
	 * 
	 * @param graph
	 * @param source
	 * @param dest
	 * @return
	 */

	public static ArrayList<Integer> doBFSShortestPath(TestGraph graph, int source, int dest)
	{
		ArrayList<Integer> shortestPathList = new ArrayList<Integer>();
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

		if (source == dest)
			return null;
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> pathStack = new Stack<Integer>();

		queue.add(source);
		pathStack.add(source);
		visited.put(source, true);

		while(!queue.isEmpty())
		{
			int u = queue.poll();
			ArrayList<Integer> adjList = graph.getOutEdges(u);

			for(int v : adjList)
			{
				if(!visited.containsKey(v))
				{
					queue.add(v);
					visited.put(v, true);
					pathStack.add(v);
					if(u == dest)
						break;
				}
			}
		}


		//To find the path
		int node, currentSrc=dest;
		shortestPathList.add(dest);
		while(!pathStack.isEmpty())
		{
			node = pathStack.pop();
			if(graph.isNeighbor(currentSrc, node))
			{
				shortestPathList.add(node);
				currentSrc = node;
				if(node == source)
					break;
			}
		}

		return shortestPathList;
	}


	/**
	 * 
	 * Method to find the shortest path
	 */
	public static void findShortestPath()
	{

		TestGraph graph = constructGraph();
		Scanner scanner = new Scanner(System.in);
		int source = scanner.nextInt();
		int dest = scanner.nextInt();

		ArrayList<Integer> shortestPathList =  doBFSShortestPath(graph, source, dest);

		System.out.print("[ ");
		for(int node : shortestPathList)
		{
			System.out.print(node+" ");
		}
		System.out.print("]");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BFSShortestPathGraph.findShortestPath();
	}
}
class TestGraph{

	
	public static ArrayList<Integer>[] adjacencyList=null;
	public int noOfVertices;
	
	
	public TestGraph(int noOfVertices)
	{
		adjacencyList=(ArrayList<Integer>[])new ArrayList[noOfVertices+1];
		this.noOfVertices=noOfVertices;
		for(int i=0;i<(noOfVertices+1);i++)
			adjacencyList[i]=new ArrayList<Integer>();
	}

	/**
	 * 
	 * @param u
	 * @param v
	 * @param w
	 * To add edges to the adjacency list in graph
	 */
	public void addEdge(int u, int v)
	{
		if(adjacencyList[u]==null)
			adjacencyList[u]=new ArrayList<Integer>();
		adjacencyList[u].add(v);
	}
	
	/**
	 * 
	 * @param u
	 * @param v
	 * To remove the edge from the graph
	 */
	public void removeEdge(int u, int v)
	{
		int indexToBeRemoved=-1;
		ArrayList<Integer> edgeList=adjacencyList[u];
		for(int i=0;i<adjacencyList[u].size();i++)
		{
			int val=edgeList.get(i);
			if(val==v)
			{
				indexToBeRemoved=i;
			}
		}
		edgeList.remove(indexToBeRemoved);
	}
	
	/**
	 * Method to verify whether u and v are neighbors
	 * @param u
	 * @param v
	 * @return
	 */
	public boolean isNeighbor(int u, int v)
	{
		if(adjacencyList[u]==null)
			return false;
		return adjacencyList[u].contains(v);
					
	}
	
	/**
	 * Method to return the size of the graph
	 * @return
	 */
	public int size()
	{
		return adjacencyList.length;
	}
	/**
	 * 
	 * @param u
	 * @return
	 * To return the outgoing edges for the given source
	 */
	public ArrayList<Integer> getOutEdges(int u)
	{
		return adjacencyList[u];
	}

	/**
	 * Method to return the adjacency list
	 * @return
	 */
	public ArrayList<Integer>[] getAdjacencyList()
	{
		return adjacencyList;
	}
	
	public void printGraph()
	{
		ArrayList<Integer> edgeList;
		for(int i=1;i<=noOfVertices;i++)
		{
			edgeList=adjacencyList[i];
			if(edgeList!=null)
			{
			for(int v : edgeList)
				System.out.println("u : "+i+" v : "+v);
			}
		}
	}
	/**
	 * 
	 * @param args
	 * Main function to test the graph
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestGraph graph=new TestGraph(3);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 1);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.printGraph();
		
	}
	
	

}