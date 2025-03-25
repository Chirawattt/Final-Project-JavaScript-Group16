package com.example.final_project_javascript_group16;

import android.content.Context;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

public class DialogUtil {

    public interface DialogCallback {
        void onConfirmed();
    }

    public static void showCustomDialog(
            Context context,
            String title,
            String message,
            String positiveText,
            String negativeText,
            @ColorRes int positiveColor,
            @ColorRes int negativeColor,
            @Nullable DialogCallback onConfirm
    ) {
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveText, (dialogInterface, which) -> {
                    if (onConfirm != null) {
                        onConfirm.onConfirmed();
                    }
                })
                .setNegativeButton(negativeText, null)
                .create();

        dialog.setOnShowListener(d -> {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(context, positiveColor));
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(context, negativeColor));
        });

        dialog.show();
    }
}