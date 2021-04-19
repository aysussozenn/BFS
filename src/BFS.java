
import java.util.ArrayList;
import java.util.Arrays;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.LinkedList;
	import java.util.Queue;
import java.util.Stack;
	public class BFS{
	        public static void main(String a[])
	        {
	                Node A = new Node("A",null);
	                Node B = new Node("B",null);
	                Node C = new Node("C",null);
	                Node D = new Node("D",null);
                        Node E = new Node("E",null);
	                Node F = new Node("F",null);
	                Node G = new Node("G",null);
	                Node H = new Node("H",null);
	                
	                A.adjList=new Node[] {B,C};
	                B.adjList=new Node[] {A};
	                C.adjList=new Node[] {A,D};
	                D.adjList=new Node[] {E,F};
	                E.adjList=new Node[] {D};
                        F.adjList=new Node[] {D,G};
	                G.adjList=new Node[] {F};	              
                        H.adjList=new Node[] {};
	                
	                System.out.println(Node.shortestPath(B, G));
	        }
	}
	class Node
	{
	        String nodeName;
	        Node [] adjList;
	        
	        public Node(String nodeName, Node[] adjList)
	        {
	                this.nodeName = nodeName;
	                this.adjList = adjList;
	        }
	        
	        public static String shortestPath(Node start, Node end)
	        {
	                Queue<Node> queue=new LinkedList<>();
	                HashMap<Node,Boolean> visited =new HashMap<>();
	                HashMap<Node,Node> pathMap =new HashMap<>(); 
                        Stack<Node> pathStack = new Stack<>();
                        
	                queue.add(start);
                        pathStack.push(start);
	                Node curValue;
	                visited.put(start,true);
                     
                                                
	                while(!queue.isEmpty())
	                {
	                        curValue=queue.poll();
	                                
	                        for(Node node:curValue.adjList)
	                        {
	                                if(!visited.containsKey(node)) {
	                                        queue.add(node);
                                                visited.put(node, true);
	                                        pathMap.put(curValue, node);
	                                        pathStack.add(node);
	                                        
	                                }
	                        }
	                }
	                              
	                curValue=start;
	                String path=curValue.nodeName;
	                while(!pathStack.empty())
                            
	                {	curValue=pathMap.get(curValue);
	                        path=path+"->"+curValue.nodeName;
	                         
	                }
	                return path;
	        }
	}
