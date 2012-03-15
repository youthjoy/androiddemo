package com.youth.test;

import java.util.ArrayList;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.*;

public class smsmanger extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.sms);
		btnSend = (Button) findViewById(R.id.btnSend);
		edtPhoneNo = (EditText) findViewById(R.id.edtPhoneNo);
		edtContent = (EditText) findViewById(R.id.edtContent);

		btnSend.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String phoneNo = edtPhoneNo.getText().toString();
				String message = edtContent.getText().toString();
				if (phoneNo.length() > 0 && message.length() > 0) {
					// call sendSMS to send message to phoneNo
					sendSMS(phoneNo, message);
				} else
					Toast.makeText(getBaseContext(),
							"Please enter both phone number and message.",
							Toast.LENGTH_SHORT).show();
			}
		});
	}

	private Button btnSend;
	private EditText edtPhoneNo;
	private EditText edtContent;

	private void sendSMS(String phoneNumber, String message) {
		// ---sends an SMS message to another device---
		SmsManager sms = SmsManager.getDefault();
		PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this,
				smsmanger.class), 0);
		
		// if message's length more than 70 ,
		// then call divideMessage to dive message into several part ,and call
		// sendTextMessage()
		// else direct call sendTextMessage()
		if (message.length() > 70) {
			ArrayList<String> msgs = sms.divideMessage(message);
			for (String msg : msgs) {
				sms.sendTextMessage(phoneNumber, null, msg, pi, null);
			}
		} else {
			sms.sendTextMessage(phoneNumber, null, message, pi, null);
		}
		Toast.makeText(smsmanger.this, "短信发送完成", Toast.LENGTH_LONG).show();
	}
}