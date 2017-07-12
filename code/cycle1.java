void setup() {
  size(width, height);
  colorMode(HSB, 360, 100, 100, 100);
  background(360);
  smooth();

  translate(width/2, height/2);

  int num = 20;

  for (int i = 0; i < num; i++) {

    rotate(PI/(num/2));

    // triagle
    noStroke();
    fill(20, 100, 100, 20);
    beginShape();
      vertex(20, 20);
      vertex(105, 100);
      vertex(-150, 150);
     endShape();

    // rect
    noStroke();
    fill(300, 100, 100, 30);
    rect(50, 50, 50, 50);

    // line
    strokeWeight(1);
    stroke(random(360), 100, 100, 30);
    // line(50, 60, 150, 160);
    line(random(45, 55), random(55, 65), random(140, 160), random(150, 160));

    stroke(random(360), 100, 100, 30);
    // line(50, 50, 150, 150);
    line(random(45, 55), random(45, 55), random(140, 160), random(140, 160));

    stroke(random(360), 100, 100, 30);
    // line(60, 50, 160, 150);
    line(random(55, 65), random(45, 55), random(150, 170), random(150, 160));

    // circle
    noStroke();
    for (int j = 1; j < 7; j++) {
      fill(random(360), 100, 100, 30);
      ellipse(random(50, 200), random(50, 250), j*5, j*5);
    }

  }
}

void mousePressed() {
  Date d = new Date();
  long current = d.getTime();
  save(current + "-screenshot.png");
}
