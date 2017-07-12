class Point {
  float x;
  float y;
  float z;
  float targetX;
  float targetY;
  float targetZ;
  float radius;

  Point() {
    setTarget();
    x = targetX;
    y = targetY;
    z = targetZ;
  }

  void setTarget() {
    if (random(2) < 1) {
      radius = 150;
    } else {
      radius = 75;
    }
    float phi = random(TWO_PI);
    float unitZ = random(-1, 1);
    targetX = radius * sqrt(1 - unitZ * unitZ) * cos(phi);
    targetY = radius * sqrt(1 - unitZ * unitZ) * sin(phi);
    targetZ = radius * unitZ;
  }

  void update() {
    if (frameCount % 120 == 0) {
      setTarget();
    }
    x += (targetX - x) * 0.05;
    y += (targetY - y) * 0.05;
    z += (targetZ - z) * 0.05;
  }

  void display() {
    stroke(0);
    strokeWeight(3);
    point(x, y, z);
  }

}

int num = 500;
Point[] points = new Point[num];

void setup() {
  size(640, 360, P3D);

  for (int i = 0; i < num; i++) {
    points[i] = new Point();
  }
}

void draw() {
  background(255);
  translate(width/2, height/2, 0);
  rotateY(frameCount * 0.01);

  for (int i = 0; i < num; i++) {
    points[i].update();
    points[i].display();
  }

  for (int i = 0; i < num; i++) {
    for (int j = i + 1; j < num; j++) {
      float d = dist(
        points[i].x,
        points[i].y,
        points[i].z,
        points[j].x,
        points[j].y,
        points[j].z
        );
      if (d < 40) {
        stroke((int) map(d, 0, 40, 0, 255));
        strokeWeight(1);
        line(
          points[i].x,
          points[i].y,
          points[i].z,
          points[j].x,
          points[j].y,
          points[j].z
          );
      }
    }
  }
}

void mousePressed() {
  Date d = new Date();
  long current = d.getTime();
  save(current + "-screenshot.png");
}
