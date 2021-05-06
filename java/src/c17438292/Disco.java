package c17438292;
import processing.core.*;

public class Disco {
    NeilsVisual nv;
    private float x;
    private float y;
    float avgAmp;
    private float angle = 0;
    private float i = 0;    

    public Disco (NeilsVisual nv, float x, float y){
        this.nv = nv;
        this.x = x;
        this.y = y;
    }

    public void render()
    {
        nv.calculateAverageAmplitude();
        float sphSize = nv.getSmoothedAmplitude();
        nv.colorMode(PConstants.HSB);
        nv.pushMatrix();
        nv.background(0);
        nv.lights();
        nv.stroke(0, 100, 100);
        nv.fill(PApplet.map(sphSize, 0, 1, 0, 360), 100, 100);
        nv.translate(x, y, -150);
        nv.rotateY(angle);
        angle += 0.01f;
        nv.sphere(200 + 50*sphSize);
        nv.popMatrix();
    }
}
