package bear.coding.com.connect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    ConnectivityManager manager;
    Button ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = (TextView)findViewById(R.id.txt);
        ConnectivityManager manager =
                (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        Button ret = (Button)findViewById(R.id.ret);
        refresh();

        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    refresh();
            }
        });
    }


    public void refresh() {
        NetworkInfo act = manager.getActiveNetworkInfo();

        String mesg = null;
        if(act != null && act.isAvailable()) {

            int type = act.getType();

            switch (type) {
                case ConnectivityManager.TYPE_WIFI:
                    mesg = "WIFI";
                    break;

                case ConnectivityManager.TYPE_WIMAX:
                    mesg = "4G";
                    break;

                case ConnectivityManager.TYPE_BLUETOOTH:
                    mesg = "bluetooth";
                    break;

                case ConnectivityManager.TYPE_MOBILE:
                    mesg = "3G";
                    break;
            }
        }
        txt.setText(mesg);
    }
}
