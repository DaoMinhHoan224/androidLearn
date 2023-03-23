package com.example.assigment_hoandmph27404.Loader;

import android.util.Log;

import com.example.assigment_hoandmph27404.DTO.Trangchu;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Newsloader {

    List<Trangchu> listNews = new ArrayList<>();
    Trangchu trangchu;
    String textContent;
    String check_string;

    public List<Trangchu> getListNews(InputStream inputStream) {
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
                            trangchu = new Trangchu();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textContent = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (trangchu != null) {
                            if(tagName.equalsIgnoreCase("item")){
                                listNews.add(trangchu);
                            }else if(tagName.equalsIgnoreCase("title")){
                                trangchu.setTitle(textContent);
                            }else if(tagName.equalsIgnoreCase("description")){

                                trangchu.setDescription(textContent);
                            }else if(tagName.equalsIgnoreCase("pubDate")){
                                check_string = textContent.substring(4,16);
                                Log.d("111111", "getListNews: " + check_string);
                                trangchu.setPubDate(check_string);
                            }else if(tagName.equalsIgnoreCase("link")){
                                trangchu.setLink(textContent);
                            }else if(tagName.equalsIgnoreCase("commemt")){
                                trangchu.setCommemt(textContent);
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
