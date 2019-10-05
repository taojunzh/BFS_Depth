package ub.cse.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
	  private int startNode;
	  private HashMap<Integer, ArrayList<Integer>> graph;
	  public Solution(int node, HashMap<Integer, ArrayList<Integer>> g){
	    startNode = node;
	    graph = g;
	  }

	  public int[] outputDistances(){
		int ret[]=new int[graph.size()];
		boolean v[]=new boolean[graph.size()];
		LinkedList<Integer> q =new LinkedList<>();
		v[startNode]=true;
		q.add(startNode);
		int temp;
		int depth=1;
		int size;
		while(q.size()>0) {
			size = q.size();
			for(int j=0; j<size;j++) {
			temp=q.poll();
			for(Integer i:graph.get(temp)) {
				if(!v[i]) {
					v[i]=true;
					ret[i]=depth;
					q.add(i);
				}
			}}
			depth+=1;
		}
		for(int i=0;i<ret.length;i++) {
			if(i!=startNode&&ret[i]==0) {
				ret[i]=-1;
			}
		}
	    return ret;
	  }
}
