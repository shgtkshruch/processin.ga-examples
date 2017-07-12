int xspacing = 16;   // How far apart should each horizontal location be spaced
int w;              // Width of entire wave
ArrayList group;
float theta = 0.0;  // Start angle at 0
float amplitude = 75.0;  // Height of wave
float period = 500.0;  // How many pixels before the wave repeats
float dx;  // Value for incrementing X, a function of period and xspacing
float[] yvalues;  // Using an array to store height values for the wave
int xnode = 0;

void setup() {
  size(600, 400);
  background(0);
  group = new ArrayList();
  w = width + 16;
  dx = (TWO_PI / period) * xspacing;
  yvalues = new float[w / xspacing];

}

void draw() {
  background(0);
  calcWave();
  renderWave();
  fill(0, 10);
  rect(0, 0, width, height);
  for (int i = 0; i < group.size(); i++) {
    ((tree)group.get(i)).update();
    if (((tree)group.get(i)).r <= 0) {
      group.remove(i);
    }
  }
  for (int i = 0; i < group.size(); i++) {
    ((tree)group.get(i)).display();
  }
}

void calcWave() {
  // Increment theta (try different values for 'angular velocity' here
  theta += 0.02;

  // For every x value, calculate a y value with sine function
  float x = theta;
  for (int i = 0; i < yvalues.length; i++) {
    yvalues[i] = sin(x) * amplitude;
    x += dx;
  }
}

void renderWave() {
  noStroke();
  fill(255);

  // A simple way to draw the wave with an ellipse at each location
  for (int x = 0; x < yvalues.length; x++) {
    ellipse(x * xspacing, height / 2 + yvalues[x], 16, 16);
    if(x == xnode){
      int size=(int)random(5, 8);
      for (int i = 0; i < size; i++) {
        group.add(new tree(x * xspacing, height / 2 + yvalues[x], 5, random(360)));
      }
    }

  }
  xnode++;
  if (xnode >= yvalues.length)
    xnode=0;
}

class tree {
  float px, py;
  float r;
  float angle;
  float v;

  tree(float e_px, float e_py, float e_r, float e_angle) {
    px = e_px;
    py = e_py;
    angle = e_angle;
    r = e_r;
  }

  void update() {
    px = px + r * 0.8 * cos(radians(angle));
    py = py + r * 0.8 * sin(radians(angle));
    angle = angle + random(-5, 5);
    if (random(20) > 19 ) {
      float temp_r = random(1, r);
      group.add(new tree(px, py, temp_r * 1.1, angle + random(-10, 10)));
      r = r - temp_r;
    }
    if (random(2)>1) {
      r = r - 0.05;
    }
  }

  void display() {
    noStroke();
    fill(255);
    ellipse(px, py, r * 2, r * 2);
  }
}

void mousePressed() {
  Date d = new Date();
  long current = d.getTime();
  save(current + "-screenshot.png");
}

