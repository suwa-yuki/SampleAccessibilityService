package jp.classmethod.android.sample.accessibilityservice;

import android.accessibilityservice.AccessibilityService;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

public class SampleAccessibilityService extends AccessibilityService {
    
    private static final String TAG = SampleAccessibilityService.class.getSimpleName();

    private Toast mToast;
    
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int type = event.getEventType();
        String typeName = "";
        switch (type) {
        case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
            typeName = "TYPE_NOTIFICATION_STATE_CHANGED";
            break;
        case AccessibilityEvent.TYPE_VIEW_CLICKED:
            typeName = "TYPE_VIEW_CLICKED";
            break;
        case AccessibilityEvent.TYPE_VIEW_FOCUSED:
            typeName = "TYPE_VIEW_FOCUSED";
            break;
        case AccessibilityEvent.TYPE_VIEW_LONG_CLICKED:
            typeName = "TYPE_VIEW_LONG_CLICKED";
            break;
        case AccessibilityEvent.TYPE_VIEW_SELECTED:
            typeName = "TYPE_VIEW_SELECTED";
            break;
        case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
            typeName = "TYPE_VIEW_TEXT_CHANGED";
            break;
        case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
            typeName = "TYPE_WINDOW_STATE_CHANGED";
            break;
        // case AccessibilityEvent.TYPE_ANNOUNCEMENT:
        case AccessibilityEventCompat.TYPE_ANNOUNCEMENT:
            typeName = "TYPE_ANNOUNCEMENT";
            break;
        // case AccessibilityEvent.TYPE_GESTURE_DETECTION_END:
        case AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END:
            typeName = "TYPE_GESTURE_DETECTION_END";
            break;
        // case AccessibilityEvent.TYPE_GESTURE_DETECTION_START:
        case AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START:
            typeName = "TYPE_GESTURE_DETECTION_START";
            break;
        // case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_END:
        case AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END:
            typeName = "TYPE_TOUCH_EXPLORATION_GESTURE_END";
            break;
        // case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START:
        case AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_START:
            typeName = "TYPE_TOUCH_EXPLORATION_GESTURE_START";
            break;
        // case AccessibilityEvent.TYPE_TOUCH_INTERACTION_END:
        case AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END:
            typeName = "TYPE_TOUCH_INTERACTION_END";
            break;
        // case AccessibilityEvent.TYPE_TOUCH_INTERACTION_START:
        case AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START:
            typeName = "TYPE_TOUCH_INTERACTION_START";
            break;
        // case AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED:
        case AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED:
            typeName = "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED";
            break;
        // case AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED:
        case AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED:
            typeName = "TYPE_VIEW_ACCESSIBILITY_FOCUSED";
            break;
        // case AccessibilityEvent.TYPE_VIEW_HOVER_ENTER:
        case AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER:
            typeName = "TYPE_VIEW_HOVER_ENTER";
            break;
        // case AccessibilityEvent.TYPE_VIEW_HOVER_EXIT:
        case AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT:
            typeName = "TYPE_VIEW_HOVER_EXIT";
            break;
        // case AccessibilityEvent.TYPE_VIEW_SCROLLED:
        case AccessibilityEventCompat.TYPE_VIEW_SCROLLED:
            typeName = "TYPE_VIEW_SCROLLED";
            break;
        // case AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED:
        case AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED:
            typeName = "TYPE_VIEW_TEXT_SELECTION_CHANGED";
            break;
        // case AccessibilityEvent.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY:
        case AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY:
            typeName = "TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY";
            break;
        // case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
        case AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED:
            typeName = "TYPE_WINDOW_CONTENT_CHANGED";
            break;
        default:
            typeName = "UNKNOWN_TYPE";
        }
        if (mToast == null) {
            mToast = Toast.makeText(getApplicationContext(), typeName, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(typeName);
        }
        mToast.show();
        
        // AccessibilityRecord ‚Ì—L–³Šm”F
        int count = AccessibilityEventCompat.getRecordCount(event);
        Log.i(TAG, "count=" + count);
        for (int i = 0; i < count; i++) {
            // AccessibilityRecord ‚ÌŽæ“¾
            AccessibilityRecordCompat record = AccessibilityEventCompat.getRecord(event, i);
            Log.i(TAG, "className=" + record.getClassName());
            // AccessibilityNodeInfo ‚ÌŽæ“¾
            AccessibilityNodeInfoCompat node = record.getSource();
            if (node != null) {
                Log.i(TAG, "parent=" + node.getParent().getClassName());
                int childCount = node.getChildCount();
                for (int j = 0; j < childCount; j++) {
                    Log.i(TAG, "child=" + node.getChild(j).getClassName());
                }
            }
        }
    }

    @Override
    public void onInterrupt() {
    }

}
