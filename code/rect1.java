void setup() {
  size(414, 736);
  background(255);
}

void draw() {
  noStroke();
  translate(mouseX, mouseY);

  pushMatrix();
  rotate(map (millis(), 0, 3000, 0, TWO_PI));
  int diameter = random(10);
  int siz1 = random(20) + 20;
  int siz2 = random(20);

  fill(255, random(255), random(255));
  rect(siz1, siz1, diameter, diameter);

  rotate(radians(45));
  fill(240);
  rectMode(CENTER);
  rect(siz2, siz2, diameter, diameter);

  popMatrix();
}

void mousePressed() {
  if (mouseButton == LEFT) {
    background(255);
  } else if (mouseButton == RIGHT) {
    Date d = new Date();
    long current = d.getTime();
    save(current + "-screenshot.png");

  }
}
