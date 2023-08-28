package com.xquare.core.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.preferencesDatastore by preferencesDataStore(name = "preferences-datastore-xquare")
