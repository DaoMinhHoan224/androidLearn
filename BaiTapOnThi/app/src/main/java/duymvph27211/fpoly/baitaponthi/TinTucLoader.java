package duymvph27211.fpoly.baitaponthi;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import duymvph27211.fpoly.baitaponthi.DTO.TinTuc;

public class TinTucLoader {
    List<TinTuc> tinTucList = new ArrayList<TinTuc>();
    TinTuc tinTuc;
    String textContent;
    public List<TinTuc> getTinTucList(InputStream inputStream){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();

            parser.setInput(inputStream,null);

            int eventType = parser.getEventType();
            while (eventType!=XmlPullParser.END_DOCUMENT){
                String tagName = parser.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("item")){
                            tinTuc = new TinTuc();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textContent  = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (tinTuc!=null){
                            if (tagName.equalsIgnoreCase("item")){
                                tinTucList.add(tinTuc);
                            }
                            else if (tagName.equalsIgnoreCase("title")){
                                tinTuc.setTitle(textContent);
                            }
                            else if (tagName.equalsIgnoreCase("link")){
                                tinTuc.setLink(textContent);
                            }
                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return tinTucList;
    }
}
