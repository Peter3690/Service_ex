package tulv.service_ex;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyServiceBinder extends Service {
    private MyBinder myBinder=new MyBinder();

    public MyServiceBinder() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public int add(int a,int b){
        return a+b;
    }
    public class MyBinder extends Binder {
        MyServiceBinder getService(){
            return MyServiceBinder.this;
        }
    }
}
