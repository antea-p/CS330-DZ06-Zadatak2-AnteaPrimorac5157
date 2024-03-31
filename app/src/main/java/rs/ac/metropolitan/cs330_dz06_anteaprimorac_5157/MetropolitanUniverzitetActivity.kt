package rs.ac.metropolitan.cs330_dz06_anteaprimorac_5157

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class MetropolitanUniverzitetActivity : AppCompatActivity() {
    private var selectedFaculty: String? = null
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.selectedOptionText)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menu.add(0, 0, 0, R.string.fit).apply {
            setIcon(R.mipmap.ic_launcher)
            setTitle(R.string.fit)
            setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM or MenuItem.SHOW_AS_ACTION_WITH_TEXT)
        }
        menu.add(0, 1, 1, R.string.fam).apply {
            setIcon(R.mipmap.metlogo)
            setTitle(R.string.fam)
            setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM or MenuItem.SHOW_AS_ACTION_WITH_TEXT)
        }
        menu.add(0, 2, 2, R.string.fdu).apply {
            setIcon(R.mipmap.ic_launcher_round)
            setTitle(R.string.fdu)
            setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM or MenuItem.SHOW_AS_ACTION_WITH_TEXT)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        selectedFaculty = when (item.itemId) {
            0 -> getString(R.string.fit)
            1 -> getString(R.string.fam)
            2 -> getString(R.string.fdu)
            else -> null
        }
        selectedFaculty?.let {
            textView.text = getString(R.string.on_option_selected_text_view, it)
        } ?: run {
            textView.text = getString(R.string.default_text_view)
        }
        return true
    }

    fun onYesButtonClick(view: View) {
        selectedFaculty?.let {
            textView.text = getString(R.string.confirmation_text_view, it)
        }?: run {
            textView.text = getString(R.string.prompt_text_view)
        }
    }

    fun onNoButtonClick(view: View) {
        selectedFaculty?.let {
            textView.text = getString(R.string.rejection_text_view, it)
        }?: run {
            textView.text = getString(R.string.prompt_text_view)
        }
    }

}
