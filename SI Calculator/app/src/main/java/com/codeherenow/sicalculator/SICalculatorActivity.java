/*
 * Copyright (C) 2013 Code Here Now - A subsidiary of Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file 
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package com.codeherenow.sicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class SICalculatorActivity extends Activity {

	private EditText etPrincipal;
	private EditText etInterestRate;

	private TextView tvYears;
	private TextView tvResult;

	private SeekBar seekYears;

	private Button buttonCalculate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sicalculator);

		etPrincipal = (EditText) findViewById(R.id.et_principal);
		etInterestRate = (EditText) findViewById(R.id.et_interest_rate);

		tvYears = (TextView) findViewById(R.id.tv_years);
		tvResult = (TextView) findViewById(R.id.tv_result);

		seekYears = (SeekBar) findViewById(R.id.seek_years);

		buttonCalculate = (Button) findViewById(R.id.button_calculate);

		seekYears.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				tvYears.setText(progress + " Year(s)");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});

		buttonCalculate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				calculate();
			}
		});

		calculate();
	}

	private void calculate() {
		int principal =  Integer.parseInt(etPrincipal.getText().toString());
		double rate = Double.parseDouble(etInterestRate.getText().toString());
		int years = seekYears.getProgress();
		double result = principal * (rate / 100) * years;

		String resultString = "The interest rate for $" + principal + " at a rate of " + rate +
				"% for " + years + String.format(" year(s) is $%.2f", result);

		tvResult.setText(resultString);
	}

}
