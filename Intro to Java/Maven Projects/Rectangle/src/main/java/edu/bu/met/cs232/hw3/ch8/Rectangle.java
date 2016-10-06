package edu.bu.met.cs232.hw3.ch8;

/**
 * Rectangle
 * 8.4
 * Created by Jennifer Konikowski on 2/20/16.
 *
 * This class defines a Rectangle. It limits length and width to between 0 and 20
 * (float) and sets the defaults to 1. It also has methods to determine the perimeter
 * and the area.
 */
public class Rectangle {
  private float length;
  private float width;

  public Rectangle()
  {
    this(1f, 1f);
  }

  public Rectangle(float length, float width)
  {
    if (length >= 0.0f && length <= 20.0f) {
      this.length = length;
    } else {
      this.length = 1.0f;
      throw new IllegalArgumentException("Length was out of range. Set to 1.0");
    }
    if (width >= 0.0f && width <= 20.0f) {
      this.width = width;
    } else {
      this.width = 1.0f;
      throw new IllegalArgumentException("Width was out of range. Set to 1.0");
    }
  }

  public float getLength(){
    return length;
  }

  public void setLength(float length){
    if (length >= 0.0f && length <= 20.0f) {
      this.length = length;
    } else {
      throw new IllegalArgumentException("Length was out of range. Set to 1.0");
    }
  }

  public float getWidth(){
    return width;
  }

  public void setWidth(float width){
    if (width >= 0.0f && width <= 20.0f) {
      this.width = width;
    } else {
      throw new IllegalArgumentException("Width was out of range. Set to 1.0");
    }
  }

  public float perimeter(){
    return (2 * (width + length));
  }

  public float area(){
    return width * length;
  }
}
