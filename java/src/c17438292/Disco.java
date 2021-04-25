package c17438292;
import processing.core.*;

public class Disco {
    NeilsVisual nv;
    private float x;
    private float y;
    private float angle = 0;
    private float i = 0;

    public Disco (NeilsVisual nv, float x, float y){
        this.nv = nv;
        this.x = x;
        this.y = y;
    }

    public void render()
    {
        nv.colorMode(PConstants.HSB);
        nv.pushMatrix();
        nv.background(0);
        nv.lights();
        nv.fill(i);
        i += 1;
        if(i>=360)
        {
            i = 0;
        }
        nv.stroke(0);
        nv.translate(x, y);
        nv.rotateY(angle);
        angle += 0.01f;
        nv.sphere(250);
        nv.popMatrix();
    }
}
