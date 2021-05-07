package ipvc.estg.problemscityapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class InfoWindowAdapter:  GoogleMap.InfoWindowAdapter {
    private var window : View
    private var context : Context

    constructor(context: Context) {
        this.context = context
        window = LayoutInflater.from(context).inflate(R.layout.info_report, null)
    }

    private fun passInfo(marker: Marker, view: View) {
        val title = marker.title
        val snippet = marker.snippet
        val titleContent = view.findViewById<TextView>(R.id.titleContent)
        val snippetContent = view.findViewById<TextView>(R.id.snippetContent)

        titleContent.text = title + "\n"
        snippetContent.text = snippet
    }

    override fun getInfoWindow(marker: Marker): View? {
        passInfo(marker, window)
        return window
    }

    override fun getInfoContents(marker: Marker): View? {
        passInfo(marker, window)
        return window
    }
}