package fr.neamar.kiss.searcher;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.List;

import fr.neamar.kiss.KissApplication;
import fr.neamar.kiss.MainActivity;
import fr.neamar.kiss.pojo.Pojo;

/**
 * Retrieve pojos from history
 */
public class HistorySearcher extends Searcher {
    private static final int MAX_RECORDS = 25;
    private SharedPreferences prefs;

    public HistorySearcher(MainActivity activity) {
        super(activity);
        prefs = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    @Override
    protected List<Pojo> doInBackground(Void... voids) {
        // Ask for records
        boolean smartHistory = !prefs.getString("history-mode", "recency").equals("recency");
        return KissApplication.getDataHandler(activity).getHistory(activity, MAX_RECORDS, smartHistory);
    }
}
