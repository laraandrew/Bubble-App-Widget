package edu.laraandrew.bubbles;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import java.util.Calendar;

public class TimeWidget extends AppWidgetProvider{
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // Create a RemoteViews object to define the layout of the widget
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 0); // i got this part from chatgpt
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        //System.out.println("THE HOUR REPORTED:"+ hour);
        if (calendar.get(Calendar.MINUTE) >= 30) {//get time and round to the nearest hour
            hour += 1;
        }
        if(hour > 12){//update widget
            views.setTextViewText(R.id.widget_text, hour - 12 + "PM");
        } else if (hour == 12) {
            views.setTextViewText(R.id.widget_text, hour + "PM");
        } else if (hour == 0) {
            views.setTextViewText(R.id.widget_text, 12 + "AM");
        }
        { // based on time of day, will update AM -> PM
            views.setTextViewText(R.id.widget_text, hour + "AM");
        }

        // Update all instances of the widget with the new layout
        appWidgetManager.updateAppWidget(appWidgetIds, views);
    }
}
