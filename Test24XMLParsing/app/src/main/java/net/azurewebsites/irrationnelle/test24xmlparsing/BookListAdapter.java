package net.azurewebsites.irrationnelle.test24xmlparsing;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.azurewebsites.irrationnelle.test24xmlparsing.vo.BookVO;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class BookListAdapter extends ArrayAdapter<BookVO> {
    private Context activity;
    private int layout;
    private List<BookVO> bookVOList;

    public BookListAdapter(Context context, int resource, List<BookVO> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.layout = resource;
        this.bookVOList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookHolder holder = null;

        if(convertView != null) {
            holder = (BookHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = ((Activity) activity).getLayoutInflater();
            convertView = inflater.inflate(layout, parent, false);

            holder = new BookHolder();
            holder.title = (TextView) convertView.findViewById(R.id.text_book_title);
            holder.author = (TextView) convertView.findViewById(R.id.text_book_author);
            holder.imageViewBook = (ImageView) convertView.findViewById(R.id.image_book);
            holder.price = (TextView) convertView.findViewById(R.id.text_book_price);
            holder.publisher = (TextView) convertView.findViewById(R.id.text_book_pulblisher);
            holder.salePrice = (TextView) convertView.findViewById(R.id.text_book_price_sale);
            convertView.setTag(holder);
        }

        BookVO bookVO = bookVOList.get(position);

        holder.title.setText(bookVO.getTitle());
        holder.author.setText(bookVO.getAuthor());
        holder.price.setText(bookVO.getPrice());
        holder.publisher.setText(bookVO.getPublisher());
        holder.salePrice.setText(bookVO.getSalePrice());

        BookImageThread t = new BookImageThread(holder.imageViewBook, bookVO.getImageURL());
        t.execute();

        return convertView;
    }

    class BookHolder {
        ImageView imageViewBook;
        TextView title;
        TextView author;
        TextView publisher;
        TextView price;
        TextView salePrice;
    }

    class BookImageThread extends AsyncTask<Void, Void, Bitmap> {
        private ImageView imageView;
        private String imgUrl;

        public BookImageThread(ImageView imageView, String imgUrl) {
            this.imageView = imageView;
            this.imgUrl = imgUrl;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap bitmap = null;

            URL url = null;

            try {
                url = new URL(imgUrl);
                BufferedInputStream is = new BufferedInputStream(url.openStream());
                bitmap = BitmapFactory.decodeStream(is);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
