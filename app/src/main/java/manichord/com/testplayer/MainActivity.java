package manichord.com.testplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_EXTRA = "file";
    private VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fileName = getIntent().getStringExtra(FILE_EXTRA);
        if (fileName == null) {
            finish();
            return;
        }

        File file = new File(Environment.getExternalStorageDirectory().getPath(),
                fileName);
        if (!file.exists()) {
            Log.e("PLAYER", "missing file; " + file.getAbsolutePath());
            return;
        }
        Log.d("PLAYER", "playing: " + file);


        videoView = (VideoView) findViewById(R.id.video1);

        videoView.setVideoURI(Uri.fromFile(file));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView.start();
            }
        });

    }

}
