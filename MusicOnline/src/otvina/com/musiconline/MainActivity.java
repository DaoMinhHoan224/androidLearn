package otvina.com.musiconline;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {

	public static final String ACTION_PLAY = "action_play";
	public static final String INDEX_MP3 = "index_mp3";

	private ArrayList<Song> songList;
	private ListView songView;

	private MusicService musicSrv;
	private Intent playIntent;
	private boolean musicBound = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		songView = (ListView) findViewById(R.id.song_list);

		songList = new ArrayList<Song>();
		getSongList();

		if (playIntent == null) {
			playIntent = new Intent(this, MusicService.class);
			startService(playIntent);
		}

		SongAdapter songAdt = new SongAdapter(this, songList);
		songView.setAdapter(songAdt);
	}

	public void getSongList() {
		songList = new SongsManager().getListSongOffline();
	}

	public void songPicked(View view) {
		Intent intent = new Intent(ACTION_PLAY);
		intent.putExtra(INDEX_MP3, Integer.parseInt(view.getTag().toString()));
		sendBroadcast(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_shuffle:
			// shuffle
			break;
		case R.id.action_end:
			stopService(playIntent);
			musicSrv = null;
			System.exit(0);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
