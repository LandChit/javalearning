package Helpers;

public class ProductDetails {
    private String name;
    private String description;
    private double price;
    private String image;

    public ProductDetails(double price,  String name, String image, String description) {
        this.price = price;
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    // setters this wouldn't work no?? unless you set a variable for that particular class?
//    public void setPrice(double price){
//        this.price = price;
//    }
//    public void setAmount(int amount){
//        this.amount = amount;
//    }
//    public void setName(String name){
//        this.name = name;
//    }
//    public void setDescription(String description){
//        this.description = description;
//    }
//    public void setImage(String image){
//        this.image = image;
//    }

    @Override
    public String toString(){
        return  "name: "+name +
                "\ndescription: " +description+
                "\nprice: " + price +
                "\nimage: "+ image;
    }

}