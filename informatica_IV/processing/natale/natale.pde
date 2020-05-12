import java.util.Vector;
import java.util.Iterator;
import gab.opencv.OpenCV;
import processing.video.*;

//create a video object
Capture video;

//create objects for face recognition
OpenCV cv;
PImage src;
BordersSet borders;
Snow snow;

//become true hen mouseClicked riggered, and take a photo
Boolean have_photo = false;


void setup() {

  //show all cameras avaible
  printArray(Capture.list());
  
  //set the camera and start capturing
  video = new Capture(this, Capture.list()[1]);
  video.start();
  
  //at the start the image is equal tot null
  src = createImage(800, 600, ARGB);
  size(800, 600);

  //start working on the image to detect borders
  cv = new OpenCV(this, src);
  borders = new BordersSet(cv);
  
  //create snow 
  snow = new Snow(1000);
}

//function that triggers when click the windows
void mouseClicked(){
  have_photo = true;
}

void draw() {
  
  surface.setSize(src.width, src.height);
  background(255);
  
  //if we haven't already take a photon display what the camera see, with live borders
  if (!have_photo) {
    if (video.available()) {
      video.read();
      src.copy(video, 0, 0, video.width, video.height, 0, 0, src.width, src.height);
    }
  }
  tint(255, 100);
  image(src, 0, 0);
  
  //detect the borders
  borders.setSource(src);
  borders.parseBorders(1);  //precision (< is more precise)

  //let me iterate on array with coords
  Iterator border = borders.getBorders().iterator();
  while(border.hasNext()) {  //if is there is borders left in the array
    ( (Border) border.next()).show();  //shoe the border
  }
  
  //when photo taken start snowing
  if (have_photo) snow.letItSnow(borders.getBorders());
  
  
  borders.clear();
}
