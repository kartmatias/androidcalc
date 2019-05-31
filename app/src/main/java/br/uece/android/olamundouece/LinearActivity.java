package br.uece.android.olamundouece;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LinearActivity extends AppCompatActivity {

    Integer contador = 0;
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;

    private final String CHANNEL_ID = "hello_notifications";
    private final int NOTIFICATION_ID = 001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        ImageView imageview = findViewById(R.id.imageView3);
        Drawable earthAnimaton = imageview.getDrawable();
        if (earthAnimaton instanceof Animatable) {
            ((Animatable)earthAnimaton).start();
        }

    }

    public void onClickChangeAnim(View v){

        MediaPlayer mp = MediaPlayer.create(this, R.raw.brakes);
        ImageView imageview = findViewById(R.id.imageView3);
        if (contador == 0) {
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.earthanimationright));
            contador = 1;
        } else {
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.earthanimationleft));
            contador = 0;
        }
        Drawable earthAnimaton = imageview.getDrawable();
        if (earthAnimaton instanceof Animatable) {
            ((Animatable)earthAnimaton).stop();
            try {
                if (mp.isPlaying()) {
                    mp.stop();
                    mp.release();
                    mp = MediaPlayer.create(this, R.raw.brakes);
                } mp.start();
            } catch(Exception e) { e.printStackTrace(); }

            ((Animatable)earthAnimaton).start();
        }

    }

    public void onClickShowNotification(View v) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);

        builder.setSmallIcon(R.drawable.ic_notification);
        builder.setContentTitle("Notificaçao Hello");
        builder.setContentText("Alerta: aplicaçao android com padroes UECE")
        .setStyle(new NotificationCompat.BigTextStyle()
                .bigText("Much longer text that cannot fit one line..."))
        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

    }

    public void chamaTeamActivity(View v){
        startActivity(new Intent(this, TeamActivity.class));
    }

    public void onClickCamera(View v)
    {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
}
        else
        {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST) {
            if (resultCode == RESULT_OK) {
                if(data != null) {
                    Bundle bundle = data.getExtras();
                    Bitmap bitmap = (Bitmap) bundle.get("data");

                    LinearLayout linear = (LinearLayout) findViewById(R.id.linearLay);
                    Drawable dr = new BitmapDrawable(bitmap);
                    (linear).setBackgroundDrawable(dr);

                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(getBaseContext(), "A captura foi cancelada",
                            Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(getBaseContext(), "A câmera foi fechada",
                            Toast.LENGTH_SHORT);
                }
            }
        }
    }

}
