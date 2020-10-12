import java.awt.Color;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;


public class Algorithms{

	public static void FloodFillDFS(PixelVertex v, ImageViewer viewer, Color fillColour){
		Stack<PixelVertex> theStack =new Stack<>(); //create an empty stack
		theStack.push(v);
		v.visited = true;
		//ArrayList<PixelVertex> List = new ArrayList<>();;
		viewer.setPixel(v.getX(),v.getY(),fillColour);
		while (!theStack.isEmpty()){
			PixelVertex vvertex = theStack.pop();
			PixelVertex[] neig = vvertex.getNeighbours();
				viewer.setPixel(vvertex.getX(),vvertex.getY(),fillColour);
			if (neig.length != 0){
				for (int i=0;i<neig.length;i++){
					if (neig[i].visited == false){
						neig[i].visited = true;
						theStack.push(neig[i]);

					}
				}
			}
	}

}

	/*
	FloodFillBFS(v, viewer, fillColour)
	 Traverse the component the vertex v using BFS and set the colour
	 of the pixels corresponding to all vertices encountered during the
	 traversal to fillColour.

	 To change the colour of a pixel at position (x,y) in the image to a
	 colour c, use
		viewer.setPixel(x,y,c);
*/

	public static void FloodFillBFS(PixelVertex v, ImageViewer viewer, Color fillColour){
		Queue<PixelVertex> theQueue =new LinkedList<>(); //create an empty queue
		theQueue.add(v);
		v.visited = true;
		viewer.setPixel(v.getX(),v.getY(),fillColour);
		while (! theQueue.isEmpty()){ //the worst case running time is O(4n), I think
			PixelVertex vvertex = theQueue.remove();
			PixelVertex[] neig = vvertex.getNeighbours();
			if (neig.length != 0){
				for (int i=0;i<neig.length;i++){
					if (neig[i].visited == false){
						neig[i].visited = true;
						theQueue.add(neig[i]);
						//w[i].getDegree();
						viewer.setPixel(neig[i].getX(),neig[i].getY(),fillColour);
					}
				}
		}
}
	}

	/* OutlineRegionDFS(v, viewer, outlineColour)
	   Traverse the component the vertex v using DFS and set the colour
	   of the pixels corresponding to all vertices with degree less than 4
	   encountered during the traversal to outlineColour.

	   To change the colour of a pixel at position (x,y) in the image to a
	   colour c, use
			viewer.setPixel(x,y,c);
	*/
	public static void OutlineRegionDFS(PixelVertex v, ImageViewer viewer, Color outlineColour){

		Stack<PixelVertex> theStack =new Stack<>(); //create an empty stack
		theStack.push(v);
		v.visited = true;

		while (!theStack.isEmpty()){
			PixelVertex vvertex = theStack.pop();
			PixelVertex[] neig = vvertex.getNeighbours();
			if (neig.length != 0){
				for (int i=0;i<neig.length;i++){
					if (neig[i].visited == false){
						if(neig[i].getDegree()<4){
							viewer.setPixel(neig[i].getX(),neig[i].getY(),outlineColour);
						}
						neig[i].visited = true;
						theStack.push(neig[i]);

					}
				}
			}
	}

	}

	/* OutlineRegionBFS(v, viewer, outlineColour)
	   Traverse the component the vertex v using BFS and set the colour
	   of the pixels corresponding to all vertices with degree less than 4
	   encountered during the traversal to outlineColour.

	   To change the colour of a pixel at position (x,y) in the image to a
	   colour c, use
			viewer.setPixel(x,y,c);
	*/
	public static void OutlineRegionBFS(PixelVertex v, ImageViewer viewer, Color outlineColour){
		Queue<PixelVertex> theQueue =new LinkedList<>();
		theQueue.add(v);
		v.visited = true;
		while (! theQueue.isEmpty()){
			PixelVertex vvertex = theQueue.remove();
			PixelVertex[] neig = vvertex.getNeighbours();
			if (neig.length != 0){
				for (int i=0;i<neig.length;i++){
					if (neig[i].visited == false){
						if(neig[i].getDegree()<4){
							viewer.setPixel(neig[i].getX(),neig[i].getY(),outlineColour);
						}
						neig[i].visited = true;
						theQueue.add(neig[i]);
					}
				}
		}
}
	}


}
