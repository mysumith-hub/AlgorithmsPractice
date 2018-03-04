package com.algorithms.ds;

import java.util.LinkedList;
import java.util.*;

//This class represents a directed graph using adjacency list
//representation
public class GraphExample
{
 private int V;   // No. of vertices
 private LinkedList<Integer> adj[]; //Adjacency Lists
 // Constructor
 GraphExample(int v)
 {
     V = v;
     adj = new LinkedList[v];
     for (int i=0; i<v; ++i)
         adj[i] = new LinkedList<Integer>();
 }

 // Function to add an edge into the graph
 void addEdge(int v,int w)
 {
     adj[v].add(w);
 }

 // prints BFS traversal from a given source s
 void BFS(int s)
 {
     // Mark all the vertices as not visited(By default
     // set as false)
     boolean visited[] = new boolean[V];

     // Create a queue for BFS
     LinkedList<Integer> queue = new LinkedList<Integer>();
     // Mark the current node as visited and enqueue it
     visited[s]=true;
     queue.add(s);

     while (queue.size() != 0)
     {
         // Dequeue a vertex from queue and print it
         s = queue.poll();
         System.out.print(s+" ");

         // Get all adjacent vertices of the dequeued vertex s
         // If a adjacent has not been visited, then mark it
         // visited and enqueue it
         Iterator<Integer> i = adj[s].listIterator();
         while (i.hasNext())
         {
             int n = i.next();
             if (!visited[n])
             {
                 visited[n] = true;
                 queue.add(n);
             }
         }
     }
 }

 // Driver method to
 public static void main(String args[])
 {
	 GraphExample g = new GraphExample(4);

     g.addEdge(0, 1);
     g.addEdge(0, 2);
     g.addEdge(1, 2);
     g.addEdge(2, 0);
     g.addEdge(2, 3);
     g.addEdge(3, 3);

     System.out.println("Following is Breadth First Traversal "+
                        "(starting from vertex 2)");

     g.BFS(2);
     System.out.println();
     System.out.println("----");
     AdjacencyMatrixEx adjacencyMatrixEx = new AdjacencyMatrixEx(5);
     adjacencyMatrixEx.addVertex(0, 1);
     adjacencyMatrixEx.addVertex(0, 4);
     adjacencyMatrixEx.addVertex(1, 2);
     adjacencyMatrixEx.addVertex(1, 3);
     adjacencyMatrixEx.addVertex(1, 4);
     adjacencyMatrixEx.addVertex(2, 3);
     adjacencyMatrixEx.print();
 }
}

class AdjacencyMatrixEx{
	
	int[][] matrix ;
	
	public AdjacencyMatrixEx(int size){
		matrix = new int[size][size];
	}
	
	public void addVertex(int vertx, int edge){
		matrix[vertx][edge] = 1;
	}
	public void print(){
		for(int i=0;i<matrix.length;i++){
			for(int k=0;k<matrix.length;k++){
//				System.out.println(i+"-"+k+":"+matrix[i][k]);
				System.out.print(matrix[i][k]+" ");
			}
			System.out.println();
		}
	}
}