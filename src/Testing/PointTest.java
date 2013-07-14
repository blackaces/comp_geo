package Testing;

import org.junit.Test;
import org.junit.Assert;
import DataStructures.Point;

import static java.lang.Math.*;

/**
 * Created with IntelliJ IDEA.
 * User: ben
 * Date: 7/12/13
 * Time: 4:46 PM
 */
public class PointTest {
  @Test
  public void testGetXOne() throws Exception {
    Point testPointOne = new Point(12, 13);
    Assert.assertEquals(testPointOne.getX(), 12, 0);

    Point testPointTwo = new Point(0, 0);
    Assert.assertEquals(testPointTwo.getX(), 0, 0);

    Point testPointThree = new Point(-5, 0);
    Assert.assertEquals(testPointThree.getX(), -5, 0);
  }

  @Test
  public void testGetY() throws Exception {
    Point testPointOne = new Point(12, 13);
    Assert.assertEquals(testPointOne.getY(), 13, 0);

    Point testPointTwo = new Point(0, 0);
    Assert.assertEquals(testPointTwo.getY(), 0, 0);

    Point testPointThree = new Point(0, -5);
    Assert.assertEquals(testPointThree.getY(), -5, 0);
  }

  @Test
  public void testCalculatePolar() throws Exception {
    Point srcOne = new Point(0, 0);
    Point destOne = new Point(1, 1);
    destOne.calculatePolar(srcOne);

    Assert.assertEquals("Test 1: Polar Distance incorrect", sqrt(2), destOne.getPolarDistance(), 0.01);
    Assert.assertEquals("Test 1: Polar Angle incorrect", toDegrees(atan(1)), destOne.getPolarAngle(), 0.01);

    Point srcTwo = new Point(1.5, 1.5);
    Point destTwo = new Point(1, 1);
    destTwo.calculatePolar(srcTwo);

    Assert.assertEquals("Test2: Polar Distance incorrect", (1 / sqrt(2)), destTwo.getPolarDistance(), 0.01);
    Assert.assertEquals("Test2: Polar Angle incorrect", toDegrees(Math.atan2(-0.5, -0.5)), destTwo.getPolarAngle(), 0.01);
  }


  @Test
  public void testGetPolarAngle() throws Exception {

  }


}
