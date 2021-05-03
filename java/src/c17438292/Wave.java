package c17438292;

import processing.core.PApplet;

public class Wave
 {
    NeilsVisual nv;
    float borderL, borderR, borderT, borderB;
    float j = 0;

    public Wave (NeilsVisual nv, float x1, float y1, float x2, float y2)
    {
        this.nv = nv;
        this.borderL = x1;
        this.borderR = x2;
        this.borderT = y1;
        this.borderB = y2;
    }

    public void render()
    {
        nv.colorMode(PApplet.RGB);
        for(int i = 0 ; i < nv.getAudioBuffer().size() ; i ++)
        {
            if(borderT == borderB)
            {
                j = PApplet.map(i, 0, nv.getAudioBuffer().size(),borderL, borderR);
                nv.stroke( 255, 255, 0);
                nv.line(j, borderT, j, borderT + 50* nv.getAudioBuffer().get(i));
            }else
            {
                j = PApplet.map(i, 0, nv.getAudioBuffer().size(),borderT, borderB);
                nv.stroke( 255, 255, 0);
                nv.line(borderL, j, borderR + 50* nv.getAudioBuffer().get(i), j);
            }
        } 
    }
}
