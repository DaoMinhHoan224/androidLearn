package duymvph27211.fpoly.baitaponthi;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import duymvph27211.fpoly.baitaponthi.Adapter.Adapter_item_view;
import duymvph27211.fpoly.baitaponthi.DAO.TinTucDAO;
import duymvph27211.fpoly.baitaponthi.DTO.TinTuc;

public class DownloadTinTuc extends AsyncTask<String,Void, List<TinTuc>> {
    Context context;
    MainActivity activity;
    TinTucDAO tinTucDAO;
    LinearLayout main_content;

    public DownloadTinTuc(Context context, MainActivity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    protected List<TinTuc> doInBackground(String... strings) {
        TinTucLoader loader = new TinTucLoader();
        List<TinTuc> list = new ArrayList<TinTuc>();
        tinTucDAO = new TinTucDAO(context);
        try {
            URL urllink = new URL(strings[0]);
            HttpsURLConnection urlConnection = (HttpsURLConnection) urllink.openConnection();
            urlConnection.connect();

            if (urlConnection.getResponseCode()==200){
                InputStream inputStream = urlConnection.getInputStream();
                list = loader.getTinTucList(inputStream);
                for (int i = 0; i <list.size() ; i++) {
                    TinTuc obj = new TinTuc();
                    obj.setTitle(list.get(i).getTitle());
                    obj.setLink(list.get(i).getLink());
                    tinTucDAO.insertTinTuc(obj);
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        list = tinTucDAO.getAll();

        return null;
    }

    @Override
    protected void onPostExecute(List<TinTuc> tinTucs) {
        super.onPostExecute(tinTucs);
        Log.d("aaaaaa", "onPostExecute: ");

        tinTucs = tinTucDAO.getAll();

        for (int i = 0; i < tinTucs.size(); i++) {

             Log.d("aaaaaaa", "onPostExecute: id: " +i+" - "+tinTucs.get(i).getTitle());
        }


        ListView listView = activity.findViewById(R.id.listView);
        Adapter_item_view adapter = new Adapter_item_view(activity.getApplicationContext(),activity,tinTucs );
        listView.setAdapter(adapter);
        Snackbar snackbar= Snackbar.make(main_content,"Đã load xong",Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
