package hoandmph27404.fpoly.xmlpullparser;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import hoandmph27404.fpoly.xmlpullparser.DTO.ProductDTO;

public class ProductLoader {
    List<ProductDTO> productDTOList= new ArrayList<ProductDTO>();
    ProductDTO productDTO;
    String textContent;

    public List<ProductDTO> getProductDTOList (InputStream inputStream){
        try {
            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            XmlPullParser parser= factory.newPullParser();

            // truyền nguồn dữ liệu
            parser.setInput(inputStream,null);

            //xác định eventtype
            int eventType=parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                // viết code xử lý ở đây
                String tagName=parser.getName();
                Log.d("zzzzz", "Tag name = " + tagName + ", Độ sâu của thẻ = " + parser.getDepth() + ", event = " +eventType);
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        // bắt đầu vào 1 thẻ
                        if (tagName.equalsIgnoreCase("product")){
                            productDTO=new ProductDTO();
                        }
                        break;
                        case XmlPullParser.TEXT:
                            textContent= parser.getText();
                            break;

                    case XmlPullParser.END_TAG:
                        if (productDTO !=null){
                            if (tagName.equalsIgnoreCase("product"))
                                productDTOList.add(productDTO);
                            else if (tagName.equalsIgnoreCase("name"))
                                productDTO.setName(textContent);
                            else if (tagName.equalsIgnoreCase("price"))
                                productDTO.setPrice(Integer.parseInt(textContent));
                        }
                        break;
                    default:
                        Log.d("zzzz","eventType khac: " + eventType + ", tag= " + tagName);
                        break;
                }

                // viết lệnh chuyển event type để vòng lặp khôgn bị treo
                // để ở cuối cùng của lệnh while
                eventType=parser.next();
            }
        }catch (XmlPullParserException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return productDTOList;
    }
}
