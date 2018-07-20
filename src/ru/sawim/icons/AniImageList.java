package ru.sawim.icons;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.MultiCallback;
import ru.sawim.SawimApplication;
import ru.sawim.comm.DrawableCallback;

import java.io.InputStream;


public class AniImageList extends ImageList {

    private AniIcon[] icons;
    private static final int WAIT_TIME = 100;

    public AniImageList() {
    }

    public Icon iconAt(int index) {
        if (index < size() && index >= 0) {
            return icons[index];
        }
        return null;
    }

    public int size() {
        return icons != null ? icons.length : 0;
    }

    private String getAnimationFile(String resName, int i) {
        return resName + "/" + (i + 1) + ".gif";
    }

    public void load(String resName, int iconsSize, int h) {
        try {
            icons = new AniIcon[iconsSize];
            int smileCount = iconsSize;
            for (int smileNum = 0; smileNum < smileCount; ++smileNum) {
                GifDrawable image = new GifDrawable(SawimApplication.getResourceAsStream(getAnimationFile(resName, smileNum)));
//                DrawableCallback drawableCallback = new DrawableCallback();
//                image.setCallback(drawableCallback);
                image.start();
                icons[smileNum] = new AniIcon(image);
//                icons[smileNum].setDrawableCallback(drawableCallback);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}