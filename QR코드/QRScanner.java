package com.example.allergyproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRScanner extends AppCompatActivity {
    /* QR code scanner 객체 */
    private IntentIntegrator qrScan;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* QR code Scanner Setting */
        qrScan = new IntentIntegrator(this);
        qrScan.setOrientationLocked(false); // default : 세로모드
        qrScan.setPrompt("QR코드를 스캔해 주세요");
        qrScan.initiateScan();
        resultText = (TextView) findViewById(R.id.QRresult);
    }
    /* Getting the Scan Results */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Log.v("qrcode ::", "no contents");
            } else { //QR코드, 내용 존재
                try {
                    /* QR 코드 내용*/
                    String temp = result.getContents();

                    /* 로직
                     *
                     * 로직 끝 */

                    Log.v("qrcode Contents:", temp);
                    Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.v("Exception ::", "QR code fail");
                    resultText.setText(result.getContents());
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

