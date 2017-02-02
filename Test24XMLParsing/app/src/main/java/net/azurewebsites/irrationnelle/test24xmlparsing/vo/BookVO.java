package net.azurewebsites.irrationnelle.test24xmlparsing.vo;

/**
 * Created by irrationnelle on 2/2/17.
 */

public class BookVO {
    private String title;
    private String author;
    private String publisher;
    private String price;
    private String salePrice;
    private String imageURL;

    public BookVO() { }

    public BookVO(String title, String author, String publisher, String price, String salePrice, String imageURL) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.salePrice = salePrice;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "BookVO{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price='" + price + '\'' +
                ", salePrice='" + salePrice + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
