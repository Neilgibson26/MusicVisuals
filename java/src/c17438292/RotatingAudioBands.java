package c17438292;
import processing.core.*;

public class RotatingAudioBands{
    
    float radius = 200;
    float smoothedBoxSize = 0;
    float rot = 0;
    float halfw;
    float halfh;
    NeilsVisual nv;


    public RotatingAudioBands(NeilsVisual nv, float x, float y)
    {
        this.nv = nv;
        this.halfw = x;
        this.halfh = y;
    }

    public void render()
    {
        nv.colorMode(PConstants.RGB);
        nv.background(0);
        nv.fill(255);
        nv.stroke(255);
        nv.lights();
        nv.stroke(PApplet.map(nv.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        nv.camera(0, -500, 500, 0, 0, 0, 0, 1, 0);
        //nv.translate(0, 0, -250);

        nv.stroke(255);
        nv.textSize(40);
        nv.text("Thanks for Watching", (halfw/10)-70, (halfh/10)-40);

        rot += nv.getAmplitude() / 8.0f;

        nv.rotateY(rot);
        float[] bands = nv.getSmoothedBands();
        for(int i = 0 ; i < bands.length ; i ++)
        {
            float theta = PApplet.map(i, 0, bands.length, 0, PConstants.TWO_PI);

            nv.stroke(PApplet.map(i, 0, bands.length, 0, 255), 255, 255);
            float x = PApplet.sin(theta) * radius;
            float z = PApplet.cos(theta) * radius;
            float h = bands[i];
            nv.pushMatrix();
            nv.translate(x, - h / 2 , z);
            nv.rotateY(theta);
            nv.noFill();
            nv.stroke(h, h, 255);
            nv.box(50, h, 50);
            nv.popMatrix();
        }
    }
    float angle = 0;
}