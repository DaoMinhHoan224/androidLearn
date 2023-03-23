package hoanglvph27356.fpoly.test_android_nang_cao.Dowload;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import hoanglvph27356.fpoly.test_android_nang_cao.News;

public class LoaderNews {
    List<News> listNews = new ArrayList<>();
    News news;
    String textContent;
    String check_string;

    public List<News> getListNews(InputStream inputStream) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            // truyền nguồn dữ liệu
            parser.setInput(inputStream, null);
            // xác định event type
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                // viết code xử lý ở đây
                String tagName = parser.getName();
                Log.d("zzzzz", "Tag name =  " + tagName +
                        ", Độ sâu của thẻ = " + parser.getDepth() + ", event = " + eventType);
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("item")) {
                            news = new News();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textContent = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (news != null) {
                            if (tagName.equalsIgnoreCase("item")) {
                                listNews.add(news);
                            } else if (tagName.equalsIgnoreCase("title")) {
                                news.setTitle(textContent);
                            } else if (tagName.equalsIgnoreCase("pubDate")) {
                                check_string = textContent.substring(4, 16);
                                Log.d("111111", "getListNews: " + check_string);
                                news.setPubDate(check_string);
                            } else if (tagName.equalsIgnoreCase("link")) {
                                news.setLink(textContent);
                            } else if (tagName.equalsIgnoreCase("commemt")) {
                                news.setCommemt(textContent);
                            }

                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listNews;

    }
}
