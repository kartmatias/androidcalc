package br.uece.android.olamundouece;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartupReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String mensagem;
        mensagem = "Clique aqui para abri o app";
        Notification n = new Notification.Builder(context)
                .setContentTitle(context.getResources().getString(R.string.app_name))
                .setContentText(mensagem)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .build();
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(0, n);
    }


}
