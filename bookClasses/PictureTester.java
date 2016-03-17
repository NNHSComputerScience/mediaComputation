/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("Chicago.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testKeepOnlyBlue() 
  {
      Picture beach = new Picture("Chicago.jpg");
      beach.explore();
      beach.keepOnlyBlue();
      beach.explore();
    } 

  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("Chicago.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorVerticalRighttoLeft */
  public static void testMirrorVerticalRightToLeft()
  {
      Picture caterpillar = new Picture("Chicago.jpg");
      caterpillar.explore();
      caterpillar.mirrorVerticalRightToLeft();
      caterpillar.explore();
  }
  
  public static void testMirrorHorizontal() 
  {
      Picture motorcycle = new Picture("Chicago.jpg");
      motorcycle.explore();
      motorcycle.mirrorHorizontal();
      motorcycle.explore();
  } 
  
  public static void testMirrorHorizontalBotToTop()
  {
      Picture motorcycle = new Picture("redMotorcycle.jpg");
      motorcycle.explore();
      motorcycle.mirrorHorizontalBotToTop();
      motorcycle.explore();
  } 


  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("Chicago.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorArms()
  {
      Picture snowman = new Picture("snowman.jpg");
      snowman.explore();
      snowman.mirrorArms();
      snowman.explore();
    }
    
  public static void testMirrorGull()
  {
      Picture seagull = new Picture("seagull.jpg");
      seagull.explore();
      seagull.mirrorGull();
      seagull.explore();
    }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture(1252,1252);
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  public static void testKeepOnlyRed()
  {
      Picture swan = new Picture("swan.jpg");
    swan.keepOnlyRed();
    swan.explore();
    }
    
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {

// testZeroBlue();
// testKeepOnlyBlue();
// testKeepOnlyRed();
// 
// testNegate();
// testDarken();
// testGrayscale();
// testFixUnderwater();
// testMirrorVerticalRightToLeft();
// testMirrorVertical();
// testMirrorHorizontal();
// testMirrorHorizontalBotToTop();
// testMirrorTemple();
// testMirrorArms();
// testMirrorGull();
// testMirrorDiagonal();
    testCollage();
    
// testCopy();
// testEdgeDetection();
// testEdgeDetection2();
// testChromakey();
// testEncodeAndDecode();
// testGetCountRedOverValue(250);
// testSetRedToHalfValueInTopHalf();
// testClearBlueOverValue(200);
// testGetAverageForColumn(0);
  }
}