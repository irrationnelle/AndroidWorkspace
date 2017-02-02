package net.azurewebsites.irrationnelle.test24xmlparsing;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import net.azurewebsites.irrationnelle.test24xmlparsing.vo.BookVO;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by irrationnelle on 2/2/17.
 */

public class NaverBookThread extends Thread {
    private Handler handler;
    private String keyword;

    public NaverBookThread(Handler handler, String keyword) {
        this.handler = handler;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        String urlStr = null;

        try {
            urlStr = "https://openapi.naver.com/v1/search/book.xml?query="+ URLEncoder.encode(keyword, "UTF-8");
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", "tS_db6Zmod_PfR7itNKE");
            con.setRequestProperty("X-Naver-Client-Secret", "A73KGiUe7P");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();

            parser.setInput(br);

            List<BookVO> bookVOList = new ArrayList<>();
            BookVO bookVO = null;

            int eventType = parser.getEventType();

            while(eventType != XmlPullParser.END_DOCUMENT) {
                if(eventType == XmlPullParser.START_TAG) {
                    String tagName = parser.getName();
                    if (tagName.equals("title")) {
                        bookVO = new BookVO();

                        String bookTitle = parser.nextText();

                        Pattern pattern = Pattern.compile("<.?b>");
                        Matcher matcher = pattern.matcher(bookTitle);

                        if(matcher.find() == true) {
                            bookTitle = matcher.replaceAll("");
                        }

                        bookVO.setTitle(bookTitle);
                    } else if (tagName.equals("image")) {
                        bookVO.setImageURL(parser.nextText());
                    } else if (tagName.equals("author")) {
                        bookVO.setAuthor(parser.nextText());
                    } else if (tagName.equals("price")) {
                        bookVO.setPrice(parser.nextText());
                    } else if (tagName.equals("discount")) {
                        bookVO.setSalePrice(parser.nextText());
                    } else if (tagName.equals("publisher")) {
                        bookVO.setPublisher(parser.nextText());
                        bookVOList.add(bookVO);
                    }
                }
                eventType = parser.next();
            }

            Message msg = new Message();
            msg.obj = bookVOList;
            handler.sendMessage(msg);

//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = br.readLine()) != null) {
//                response.append(inputLine);
//            }
//            br.close();
//            Log.i("naver test", response.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}
