/*
 * Copyright (C) 2016 Turbo ROM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.turbo;

import android.content.Context;
import android.os.Bundle;
import android.os.ServiceManager;
import android.provider.Settings;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.view.IWindowManager;

import com.android.settings.R;
import com.android.settings.preference.SystemSettingSwitchPreference;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;

public class ButtonSettings extends SettingsPreferenceFragment {

    private static final String KEY_HARDWARE_KEYS = "hardwarekeys_settings";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.button_settings);
        
        // Hide Hardware Keys menu if device doesn't have any
        PreferenceScreen hardwareKeys = (PreferenceScreen) findPreference(KEY_HARDWARE_KEYS);
        int deviceKeys = getResources().getInteger(
                com.android.internal.R.integer.config_deviceHardwareKeys);
        if (deviceKeys == 0 && hardwareKeys != null) {
            getPreferenceScreen().removePreference(hardwareKeys);
        }

    }

    @Override
    protected int getMetricsCategory() {
        return -Integer.MAX_VALUE + 1;
    }
}
