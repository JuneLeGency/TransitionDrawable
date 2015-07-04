package legency.june.transitiondrawable;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by legency on 2015/7/3.
 */
public class Welcome extends Activity {
    TransitionDrawable welcome_background;

    private Timer timer;

    private TimerTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        init();
    }

    void init(){
        ViewGroup container = (ViewGroup) findViewById(R.id.container);
        Resources re = getResources();
        Drawable bg_0 = re.getDrawable(R.drawable.bg_0);
        Drawable bg_1 = re.getDrawable(R.drawable.bg_1);
        Drawable bg_2 = re.getDrawable(R.drawable.bg_2);
        Drawable bg_3 = re.getDrawable(R.drawable.bg_3);
        Drawable bg_4 = re.getDrawable(R.drawable.bg_4);
        Drawable bg_5 = re.getDrawable(R.drawable.bg_5);
        welcome_background =new TransitionDrawable(bg_0,bg_1,bg_2,bg_3,bg_4,bg_5);
        container.setBackground(welcome_background);
        timer = new Timer();
        task = new TimerTask() {
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        background_slide();
                    }
                });
            }
        };
        timer.schedule(task, 5 * 1000, 5 * 1000);
    }

    void background_slide(){
        welcome_background.startTransition(1000);
    }
}
