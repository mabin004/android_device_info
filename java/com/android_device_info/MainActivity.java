package com.android_device_info;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get imei
        String imei = ((TelephonyManager) this.getSystemService(TELEPHONY_SERVICE)).getDeviceId();
        TextView imei_tx = (TextView)findViewById(R.id.IMEI);
        imei_tx.setText(imei);

        //get imsi
        String imsi = ((TelephonyManager) this.getSystemService(TELEPHONY_SERVICE)).getSubscriberId();
        TextView imsi_tx = (TextView)findViewById(R.id.IMSI);
        imsi_tx.setText(imsi);

        //get ICCID
        String iccid = ((TelephonyManager) this.getSystemService(TELEPHONY_SERVICE)).getSimSerialNumber();
        TextView iccid_tx = (TextView)findViewById(R.id.ICCID);
        iccid_tx.setText(iccid);

        //phone number
        String phone = ((TelephonyManager) this.getSystemService(TELEPHONY_SERVICE)).getLine1Number();
        TextView phone_tx = (TextView)findViewById(R.id.PHONE);
        phone_tx.setText(phone);

        //android_id
        String androidId = android.provider.Settings.Secure.getString(
                getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        TextView androidid_tx = (TextView)findViewById(R.id.ANDROID_ID);
        androidid_tx.setText(androidId);

        //MAC address
        WifiManager wm = (WifiManager)getSystemService(getBaseContext().WIFI_SERVICE);
        String mac = wm.getConnectionInfo().getMacAddress();
        TextView mac_tx = (TextView)findViewById(R.id.MAC);
        mac_tx.setText(mac);




    }
}
