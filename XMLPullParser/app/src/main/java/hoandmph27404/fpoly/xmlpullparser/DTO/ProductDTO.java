package hoandmph27404.fpoly.xmlpullparser.DTO;

public class ProductDTO {
    String name;
    int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // viết phương thức toString cho đối tượng
    // để dùng cho trường hợp sử dụng ArrayAdapter

    public String toString(){
        return "name: " + this.name + ", Price: " + this.price;
    }
}
