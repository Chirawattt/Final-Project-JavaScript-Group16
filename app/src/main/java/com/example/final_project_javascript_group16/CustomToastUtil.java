package com.example.final_project_javascript_group16;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;

import java.io.IOException;

public class CustomToastUtil {

    public static void show(Context context, Activity activity,
                            String message,
                            int backgroundRes,
                            int iconRes,
                            int soundRes,
                            @Nullable String animationFile) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.custom_quiz_result_toast, null);
        LinearLayout container = layout.findViewById(R.id.toast_container);
        TextView text = layout.findViewById(R.id.toast_text);
        ImageView icon = layout.findViewById(R.id.toast_icon);

        container.setBackgroundResource(backgroundRes);
        text.setText(message);
        icon.setImageResource(iconRes);

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        // 🔊 Sound
        MediaPlayer mp = MediaPlayer.create(context, soundRes);
        if (mp.isPlaying()) mp.stop();
        mp.start();

        // 🎉 Animation
        if (animationFile != null) {
            LottieAnimationView anim = new LottieAnimationView(context);
            anim.setAnimation(animationFile);
            anim.loop(false);
            anim.playAnimation();

            FrameLayout root = (FrameLayout) activity.getWindow().getDecorView().getRootView();
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(500, 500);

            if (animationFile.equals("cheerup.json")) {
                params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                params.bottomMargin = 100;
            } else {
                params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
                params.topMargin = 100;
            }

            anim.setLayoutParams(params);
            root.addView(anim);

            new Handler().postDelayed(() -> root.removeView(anim), 3500);
        }
    }
}

