

import java.awt.Color;

public class PixelGraph{

  public int Width;
  public int Height;
  public PixelVertex[][] imageVertex; // 2D array of PixelVertex

  public PixelGraph(Color[][] imagePixels){
    this.Width = imagePixels.length;
    this.Height = imagePixels[0].length;
    this.imageVertex = new PixelVertex[Width][Height];

    for (int i=0;i< Width;i++){
      for (int j=0; j<Height;j++){
        PixelVertex image = new PixelVertex(i, j);
        imageVertex[i][j] = image;
      }
    }

    for (int x=0;x<Width;x++){
			for (int y=0; y<Height;y++){

					// if the colour of it's neighbours is the same, add to its neighbours
					// learn this flood_fill from https://zh.wikipedia.org/wiki/Flood_fill

					if (y>0){
							if (imagePixels[x][y].equals(imagePixels[x][y-1])){
								imageVertex[x][y].addNeighbour(imageVertex[x][y-1]);
							}
					}
					if (x>0){
						if (imagePixels[x][y].equals(imagePixels[x-1][y])){
							imageVertex[x][y].addNeighbour(imageVertex[x-1][y]);
						}
					}

					if (y<Height-1){
						if (imagePixels[x][y].equals(imagePixels[x][y+1]))
						imageVertex[x][y].addNeighbour(imageVertex[x][y+1]);
					}

					if (x<Width-1){
						if (imagePixels[x][y].equals(imagePixels[x+1][y]))
						imageVertex[x][y].addNeighbour(imageVertex[x+1][y]);
					}

			}
		}
  }

  /* getPixelVertex(x,y)
	   Given an (x,y) coordinate pair, return the PixelVertex object
	   corresponding to the pixel at the provided coordinates.
	   This method is not required to perform any error checking (and you may
	   assume that the provided (x,y) pair is always a valid point in the
	   image).
	*/
	public PixelVertex getPixelVertex(int x, int y){
		return imageVertex[x][y]; //PixelVertex
	}
  /* getWidth()
	   Return the width of the image corresponding to this PixelGraph
	   object.
	*/
	public int getWidth(){
		return Width;
	}

	/* getHeight()
	   Return the height of the image corresponding to this PixelGraph
	   object.
	*/
	public int getHeight(){
		return Height;
	}


}
