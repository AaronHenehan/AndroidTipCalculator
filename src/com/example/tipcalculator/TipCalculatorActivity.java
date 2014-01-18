package com.example.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	private Button btn10;
	private Button btn15;
	private Button btn20;
	private EditText etBillAmount;
	private TextView tvTipAmount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		btn10 = (Button) findViewById(R.id.btn10);
		btn15 = (Button) findViewById(R.id.btn15);
		btn20 = (Button) findViewById(R.id.btn20);
		
		setListenerAndTip(btn10, 0.1f);
		setListenerAndTip(btn15, 0.15f);
		setListenerAndTip(btn20, 0.2f);
		
		etBillAmount = (EditText) findViewById(R.id.etBillAmount);
		tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);
	}
	
	private void setListenerAndTip(Button button, final float percentTip) {
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				float bill = Float.parseFloat(etBillAmount.getText().toString());
				float tipAmount = (float)Math.round(bill * percentTip * 100)/100;
				tvTipAmount.setText(" $" + tipAmount);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

}
