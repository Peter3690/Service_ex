package tulv.service_ex;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService2 extends Service {

    MediaPlayer mp;
    public MyService2() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "tao", Toast.LENGTH_SHORT).show();
        mp=MediaPlayer.create(this,R.raw.anh);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, "bat dau", Toast.LENGTH_SHORT).show();
        mp.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "huy", Toast.LENGTH_SHORT).show();
        mp.stop();
    }


}
