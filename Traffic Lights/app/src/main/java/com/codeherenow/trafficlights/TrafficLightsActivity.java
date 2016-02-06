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

package com.codeherenow.trafficlights;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TrafficLightsActivity extends Activity implements View.OnClickListener {

	private ImageView imageGreenLight;
	private ImageView imageYellowLight;
	private ImageView imageRedLight;

	private Button buttonRed;
	private Button buttonGreen;
	private Button buttonYellow;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.traffic_lights);

		imageGreenLight = (ImageView) findViewById(R.id.image_green_light);
		imageYellowLight = (ImageView) findViewById(R.id.image_yellow_light);
		imageRedLight = (ImageView) findViewById(R.id.image_red_light);

		buttonGreen = (Button) findViewById(R.id.button_green);
		buttonYellow = (Button) findViewById(R.id.button_yellow);
		buttonRed = (Button) findViewById(R.id.button_red);

		buttonGreen.setOnClickListener(this);
		buttonYellow.setOnClickListener(this);
		buttonRed.setOnClickListener(this);
		imageGreenLight.setOnClickListener(this);
		imageYellowLight.setOnClickListener(this);
		imageRedLight.setOnClickListener(this);
	}

	/**
	 * Called when a view has been clicked.
	 *
	 * @param v The view that was clicked.
	 */
	@Override
	public void onClick(View v) {
		turnLightsOff();
		if (v == buttonGreen || v == imageGreenLight) {
			turnOnGreenLight();
		}
		else if (v == buttonYellow || v == imageYellowLight) {
			turnOnYellowLight();
		}
		else if (v == buttonRed || v == imageRedLight) {
			turnOnRedLight();
		}

	}

	private void turnOnGreenLight() {
		imageGreenLight.setImageResource(R.drawable.green_on);
	}

	private void turnOnYellowLight() {
		imageYellowLight.setImageResource(R.drawable.yellow_on);
	}

	private void turnOnRedLight() {
		imageRedLight.setImageResource(R.drawable.red_on);
	}

	private void turnLightsOff() {
		imageGreenLight.setImageResource(R.drawable.light_off);
		imageYellowLight.setImageResource(R.drawable.light_off);
		imageRedLight.setImageResource(R.drawable.light_off);
	}
}
