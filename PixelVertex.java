import java.util.Arrays;
import java.util.ArrayList;


public class PixelVertex{
  /* Add a constructor here  */
	public int x;
	public int y;
	public int countNeighbours;
	public boolean visited;
	public PixelVertex[] neighbourArray;
	private ArrayList<PixelVertex> ListofVertex;


	public PixelVertex(int x, int y){
		this.x = x;
		this.y = y;
		this.countNeighbours = 0;
		this.visited = false;
		int maxsize = 4;
		this.neighbourArray = new PixelVertex[maxsize];
		ListofVertex = new ArrayList<>();
	}

	public int getX(){
		return x;
	}

  public int getY(){
    return y;
  }

  public PixelVertex[] getNeighbours(){
    return neighbourArray;
  }

  public void addNeighbour(PixelVertex newNeighbour){
		ListofVertex.add(newNeighbour);
		countNeighbours++;
		neighbourArray = ListofVertex.toArray(new PixelVertex[0]); // convert this arraylist to array
	}


  public void removeNeighbour(PixelVertex neighbour){
    ListofVertex.remove(neighbour);
    countNeighbours--;
    neighbourArray = ListofVertex.toArray(new PixelVertex[0]); // convert this arraylist to array
  }

  public int getDegree(){
  //System.out.print(countNeighbours);
    return countNeighbours;
  }


  public boolean isNeighbour(PixelVertex otherVertex){
      neighbourArray = ListofVertex.toArray(new PixelVertex[0]);
      for (int i=0; i<countNeighbours;i++){
        if (neighbourArray[i].equals(otherVertex)){
          return true;
        }
        else{
          return false;
        }

      }
      return false;
  }

    public boolean isVisited(){
      if (visited == true){
        return true;
      }
      return false;
  }
}
