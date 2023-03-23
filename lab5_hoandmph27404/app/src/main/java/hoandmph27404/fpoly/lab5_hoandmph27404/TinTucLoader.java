package hoandmph27404.fpoly.lab5_hoandmph27404;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TinTucLoader {
    List<TinTuc> tintucList=new ArrayList<>();
    TinTuc tinTuc;
    String textContent;
    String check_string;

    public List<TinTuc> getTintucList(InputStream    inputStream){
        try {
            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            XmlPullParser parser= factory.newPullParser();

            parser.setInput(inputStream,null);

            int eventType=parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT ){
                String tagName=parser.getName();

                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("item")){
                            tinTuc=new TinTuc();
                        }
                        break;

                        case XmlPullParser.TEXT:
                        textContent = parser.getText();
                        break;

                        case XmlPullParser.END_TAG:
                            if (tinTuc!=null){
                                if (tagName.equalsIgnoreCase("item")){
                                    tintucList.add(tinTuc);
                                }
                                if (tagName.equalsIgnoreCase("title")){
                                    tinTuc.setTitle(textContent);
                                }
                                if (tagName.equalsIgnoreCase("derciption")){
                                    tinTuc.setDescription(textContent);
                                }else if(tagName.equalsIgnoreCase("pubDate")){
                                    check_string = textContent.substring(4,16);
                                    Log.d("111111", "getListNews: " + check_string);
                                    tinTuc.setDate(check_string);
                                }else if(tagName.equalsIgnoreCase("link")){
                                    tinTuc.setLink(textContent);
                                }else if(tagName.equalsIgnoreCase("commemt")){
                                    tinTuc.setComment(textContent);
                                }

                            }
                            break;
                    default:
                        Log.d("zzzz", "eventType khác: " + eventType + ", tag = " + tagName);
                        break;
                }
               eventType=parser.next();
            }
        }catch (XmlPullParserException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return tintucList;
    }
}
