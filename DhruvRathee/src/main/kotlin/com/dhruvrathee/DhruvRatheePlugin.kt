package com.dhruvrathee

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class DhruvRatheePlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(DhruvRathee())
    }
}
