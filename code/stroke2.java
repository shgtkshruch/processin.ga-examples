void setup() {
  size(414, 736);
  background(9, 35, 54);
  stroke(233, 249, 247, 30);
}

void draw() {
  line(mouseX, mouseY, 0, 0);
  line(mouseX, mouseY, width, height);
  line(mouseX, mouseY, width, 0);
  line(mouseX, mouseY, 0, height);
  line(mouseX, mouseY, width/2, 0);
  line(mouseX, mouseY, width/2, height);
  line(mouseX, mouseY, 0, height/2);
  line(mouseX, mouseY, width, height/2);
}

void mousePressed() {
  if (mouseButton == LEFT) {
    background(9, 35, 54);
  } else if (mouseButton == RIGHT) {
    Date d = new Date();
    long current = d.getTime();
    save(current + "-screenshot.png");
  }
}
