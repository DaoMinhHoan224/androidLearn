package otvina.com.musiconline;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SongsManager {
	// SDCard Path
	final String MEDIA_PATH = new String("/sdcard/Download/");
	private ArrayList<Song> songsList = new ArrayList<Song>();

	// Constructor
	public SongsManager() {

	}

	/**
	 * Function to read all mp3 files from sdcard and store the details in
	 * ArrayList
	 * */
	public ArrayList<Song> getListSongOffline() {
		File home = new File(MEDIA_PATH);

		if (home.listFiles(new FileExtensionFilter()).length > 0) {
			for (File file : home.listFiles(new FileExtensionFilter())) {

				Song song = new Song();
				song.setTitle(file.getName().substring(0,
						(file.getName().length() - 4)));
				song.setPath(file.getPath());

				// Adding each song to SongList
				songsList.add(song);
			}
		}
		// return songs list array

		Collections.sort(songsList, new Comparator<Song>() {
			public int compare(Song a, Song b) {
				return a.getTitle().compareTo(b.getTitle());
			}
		});
		return songsList;
	}

	/**
	 * Class to filter files which are having .mp3 extension
	 * */
	class FileExtensionFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return (name.endsWith(".mp3") || name.endsWith(".MP3"));
		}
	}
}
