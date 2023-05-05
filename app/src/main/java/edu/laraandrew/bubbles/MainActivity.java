package edu.laraandrew.bubbles;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends Activity {
    Random r = new Random();
    int col = Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256));
    View v = findViewById(R.id.screen);
    float circleX = 100;
    float circleY = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        circleX = (float) (v.getWidth() * Math.random());// position of circle
                        circleY = (float) (v.getHeight() * Math.random());
                        col = Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)); // color of circle
                        v.invalidate();// redraw
                        return true;
                }
                return false;
            }
        });

        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setColor(col);
            canvas.drawCircle(circleX, circleY, 100f, paint);
        }

    }
}