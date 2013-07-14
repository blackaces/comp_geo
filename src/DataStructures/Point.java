package DataStructures;

/**
 * Data Structure to hold all information regarding to the points on the xy plane
 *
 * @author Ben Ramsey
 * @version 1
 */
public class Point {
  private double x;
  private double y;
  private double polarAngle;
  private double polarDistance;
  private String description;

  /**
   * Constructor for a point in the xy plane
   *
   * @param x The x coordinate of the point.
   * @param y The y coordinate of the point.
   */
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * @param x    The x coordinate of the point.
   * @param y    The y coordinate of the point.
   * @param desc A description of the point if available, this gives the points context.
   */
  public Point(double x, double y, String desc) {
    this.x = x;
    this.y = y;
    this.description = desc;
  }

  /**
   * An internal get function for the x coordinate of the point.
   *
   * @return x: The x coordinate of the point.
   */
  private double x() {
    return x;
  }

  /**
   * An internal get function for the y coordinate of the point.
   *
   * @return y: The y coordinate of the point.
   */
  private double y() {
    return y;
  }

  /**
   * A get function for the x coordinate for use outside of this class.
   *
   * @return x: The x coordinate of the point.
   */
  public double getX() {
    return x;
  }

  /**
   * A get function for the y coordinate for use outside of this class.
   *
   * @return y: The y coordinate of the point.
   */
  public double getY() {
    return y;
  }

  /**
   * A get function for the polar angle of the point in relation to a source point.
   *
   * @return polarAngle: The polar angle of the point in relation to a source point.
   */
  public double getPolarAngle() {
    return polarAngle;
  }

  /**
   * A get function for the polar distance of the point in relation to a source point.
   *
   * @return polarDistance: The polar distance of the point in relation to a source point.
   */
  public double getPolarDistance() {
    return polarDistance;
  }

  /**
   * Calculates and sets both the polar distance and the polar angle of the point in relation to a specified point.
   *
   * @param src A point in the xy plane that the polar distance and angle are calculated in relation to.
   */
  public void calculatePolar(Point src) {
    this.polarDistance = Math.hypot(this.x() - src.getX(), this.y() - src.getY());
    this.polarAngle = Math.toDegrees(Math.atan2(this.y() - src.getY(), this.x() - src.getX()));
  }
}
