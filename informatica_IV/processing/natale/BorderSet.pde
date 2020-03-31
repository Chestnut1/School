import gab.opencv.OpenCV;

public class BordersSet {
  
  private Vector<Border> borders;  
  private PImage source;
  private OpenCV CV;
  
  public BordersSet(OpenCV CV) {
    this.CV = CV;
  }
  
  public void setSource(PImage source) {
    this.source = source; 
  }
  
  public PImage getSource() {
    return this.source; 
  }
  
  public Vector<Border> getBorders() {
    return this.borders;  
  }
  
  public void CVBorders() {
    
    this.CV.loadImage(this.source);
    this.CV.findCannyEdges(25, 75);  
    this.CV.invert();    
    this.source =  this.CV.getSnapshot();
      
  }
  
  public void parseBorders(int n) {
    
    this.CVBorders();  //set borders
    this.getSource().loadPixels();  //speed up the access to pixels
    
    //usefull points
    PVector prevl = null, prevr = null, firstl = null, firstr = null;
    Vector<Border> borders = new Vector<Border>();
    
    //scan the image troght n lines
    for (int y = 0; y < this.getSource().height; y += n) {
      
      int x;
      Boolean f;
      PVector np;
      
      x = 0;
      f = false;
      while( x < source.width && !f ) {
        int loc = x + y * width;
        float r = red(source.pixels[loc]);
        float g = green(source.pixels[loc]);
        float b = blue(source.pixels[loc]);
        if(r == 0 && g == 0 && b == 0) {
          f = true;
          np = new PVector(x, y);
          if (prevl != null) borders.add(new Border(prevl, np));
          if (firstl == null) firstl = np;
          prevl = np;
        }
        x += 1;
      }
      
      x = source.width - 1;
      f = false;
      while( x >= 0 && !f ) {
        int loc = x + y * width;
        float r = red(this.source.pixels[loc]);
        float g = green(this.source.pixels[loc]);
        float b = blue(this.source.pixels[loc]);
        if(r == 0 && g == 0 && b == 0) {
          f = true;
          np = new PVector(x, y);
          if (prevr != null) borders.add(new Border(prevr, np));
          if (firstr == null) firstr = np;
          prevr = np;
        }
        x -= 1;
      }
    
    }
    
    borders.add(new Border(firstl, firstr));
    this.borders = borders;
    
  }
  
  
  public void clear() {
    this.borders.clear(); 
  }
  
}
