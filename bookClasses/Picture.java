import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 * @author Eric Zaba eric.zaba@gmail.com
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

  
    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    public void keepOnlyRed()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setGreen(0);
                pixelObj.setBlue(0);

            }
        }

      
    }
    //just sets all the green and blue to zero.
    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setGreen(0);
                pixelObj.setRed(0);

            }
        }
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }
    //Performs the same function as the horizontal mirror, but switches rows for colu
    //umns and vice versa.
    //the loop makes it go from right to left becaseu the leftPixel is subbed in for RightPixel variable in the opposite one

    /**
     * Method mirrorVerticalRightToLeft
     * The same code as the other vertical, but switches RightPixel with leftPixel
     * to move opposite sides
     */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for(int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    public void mirrorHorizontalBotToTop() 
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        //loop that runs through the rows(height) and 'cuts' the images half
        // and redraws it inversely on the other side
        for (int row = 0; row < (height / 2); row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    } 

    /**
     * Method mirrorHorizontal
     *  Same as mirrorHorizontalBotToTop
     *  switches the pixels gathered at the top to the bottom
     *  
     */
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D(); 
        Pixel topPixel = null; 
        Pixel bottomPixel = null; 
        int height = pixels.length; 
        for (int row = 0; row < (height / 2); row++) 
        { 
            for (int col = 0; col < pixels[0].length; col++) 
            { 
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor()); 
            } 
        }  

    }


    /** Mirror  a portion of the temple so that it looks real not mirrored */
    public void mirrorTemple()
    {
        // the mirror point makes the mirror happen at exactly the center for
        // the temple and not for other imges. 
        int mirrorPoint = 277;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to the mirrorpoint
            for (int col = 13; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }
        System.out.println(count);
    }

    public void mirrorArms()
    {
        int mirrorPointA = 190;
        Pixel topPixelA = null;
        Pixel bottomPixelA = null;
        Pixel[][] pixels = this.getPixels2D();
        for(int row = 155; row < mirrorPointA; row++)
        {
            for(int col = 108; col < 170; col++)
            {
                topPixelA = pixels[row][col];
                bottomPixelA = pixels[mirrorPointA - row + mirrorPointA][col];
                bottomPixelA.setColor(topPixelA.getColor());
            }
        }
        int mirrorPointB = 198;
        Pixel topPixelB = null;
        Pixel bottomPixelB = null;
        for (int row = 171; row < mirrorPointB; row++)
        {
            for (int col = 239; col < 294; col++)
            {
                topPixelB = pixels[row][col];
                bottomPixelB = pixels[mirrorPointB - row + mirrorPointB][col];
                bottomPixelB.setColor(topPixelB.getColor());
            } 
        }
    }

    public void mirrorGull()
    {
        int mirrorPoint = 343;
        Pixel rightPixel = null;
        Pixel leftPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 238; row < 328; row++)
        {
            for (int col = 235; col < mirrorPoint; col++)
            {
                rightPixel = pixels[row][col];
                leftPixel = pixels[row][mirrorPoint - col + mirrorPoint/3];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    } 

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
        Picture mars = new Picture("mars.jpg");
        Picture marsHorizontal = new Picture(mars);
        marsHorizontal.mirrorHorizontal();
        this.copy(marsHorizontal, 0, 0);
        Picture marsKeeponlyblue = new Picture(mars);
        marsKeeponlyblue.keepOnlyBlue();
        this.copy(marsKeeponlyblue, 0, 626);
        Picture marsvertical = new Picture(mars);
        marsvertical.mirrorVertical();
        this.copy(marsvertical, 626, 0);
        Picture marszeroblue = new Picture(mars);
        marszeroblue.zeroBlue();
        this.copy(marszeroblue,2100,0);
        Picture marszerored = new Picture("mars.jpg");
        marszerored.keepOnlyRed();
        this.copy(marszerored, 626, 626);
        this.write("collage.jpg");
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture chicago = new Picture("Chicago.jpg");
        chicago.createCollage();
        chicago.keepOnlyBlue();
        chicago.zeroBlue();
        chicago.mirrorVertical();
        chicago.mirrorHorizontal();
        chicago.write("mycollage.jpg");
    }

} // this } is the end of class Picture, put all new methods before this
