package edu.laraandrew.bubbles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class BubbleView extends View{
    Random r = new Random();
    int col = Color.RED;
    float circleX = 0f;
    float circleY = 0f;
    Paint paint = new Paint();

    public BubbleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this::onTouch);
    }

    public boolean onTouch(View v, MotionEvent event) { // i got this part from chatgpt as
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            circleX = (float)(v.getWidth() * r.nextFloat());// position of circle
            circleY = (float)(v.getHeight() * r.nextFloat());
            col = Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)); // color of circle
            v.invalidate();// redraw
            return true;
        }
        return false;
        }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint = new Paint();
        float circleRadius = (float) (50 + r.nextInt(70));
        paint.setColor(col);
        canvas.drawCircle(circleX, circleY, circleRadius, paint);
    }

}
