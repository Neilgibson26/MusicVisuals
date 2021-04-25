package c17438292;

import processing.core.*;

// This is an example of a visual that uses the audio bands
public class AudioBands
{
    NeilsVisual nv;

    public AudioBands(NeilsVisual nv)
    {
        this.nv = nv; 
    }

    public void render()
    {
        float gap = nv.width / (float) nv.getBands().length;
        nv.noStroke();
        for(int i = 0 ; i < nv.getBands().length ; i ++)
        {
            nv.fill(PApplet.map(i, 0, nv.getBands().length, 255, 0), 255, 255);
            nv.rect(i * gap, nv.height, gap,-nv.getSmoothedBands()[i] * 0.2f); 
        }
    }
}