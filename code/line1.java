float x = 150, y = 150, xn = 150, yn = 150;

void setup(){
  size(300, 300);
  frameRate(60);
  background(0, 0, 0);
}

void draw(){
  if (random(0, 1) > 0.5){
    x += random(-10, 10);
  } else{
    y += random(-10, 10);
  }

  x = round(x / 10) * 10;
  y = round(y / 10) * 10;

  x = constrain(x, 0, width);
  y = constrain(y, 0, height);
  stroke(random(0, 255), random(0, 255), random(0, 255));
  line(x, y, xn, yn);
  xn = x;
  yn = y;
}

void mousePressed() {
  Date d = new Date();
  long current = d.getTime();
  save(current + "-screenshot.png");
}
