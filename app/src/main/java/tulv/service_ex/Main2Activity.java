package tulv.service_ex;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText edtSoA,edtSoB;
    TextView tvKetQua;
    Button btnCong;

    MyServiceBinder myServiceBinder;
    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
          MyServiceBinder.MyBinder binder= (MyServiceBinder.MyBinder) iBinder;
            myServiceBinder=binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            myServiceBinder=null;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWidget();
    }

    public void getWidget(){
        edtSoA=(EditText)findViewById(R.id.edtSoA);
        edtSoB=(EditText)findViewById(R.id.edtSoB);
        tvKetQua=(TextView)findViewById(R.id.tvKetQua);
        btnCong=(Button)findViewById(R.id.btnCong);
    }

    public void cong(View v){
        int a=Integer.parseInt(edtSoA.getText().toString());
        int b=Integer.parseInt(edtSoB.getText().toString());
        int kq=myServiceBinder.add(a,b);
        tvKetQua.setText(kq+"");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=new Intent(Main2Activity.this,MyServiceBinder.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        myServiceBinder.unbindService(serviceConnection);
    }
}
