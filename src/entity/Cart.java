package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //----------------------Fields-------------------------------------------------------------------------
    // Alisveris sepetinde, sepete eklenen urunleri CartItem sinifi cinsinden "items" isimli bir List de tutacagiz...
    // Sepete birden fazla CartItem eklenebileceginden instance degiskeninizi List seklende tanimlayiniz...
    // Ayrica sepetteki CartItem larin toplam fiyatini double cinsinden totalCartCost degiskeninde tutacagiz...tanimlayiniz..

    List<CartItem> items = new ArrayList<>();
    double totalCartCost;


    //----------------------Constructor---------------------------------------------------------------------
    // Alisveris sepeti olusturulurken herhangi bir degiskeni initilize etmemize gerek yoktur...


    //----------------------Instance Methods----------------------------------------------------------------
    // Return tipi void olan addToCart(CartItem item) methodu tanimlayin...
    // Bu method cagirildiginda, parametre olarak aldigi CartItem'i yukarida tanimlanan "items" List ine eklesin...
    // Ayni urun daha once eklenmis ise bu urunun sadece miktarini guncellemeniz gerekmektedir...
    // Sepete yeni urun eklenmesi veya mevcut bir urunun miktarinin arttirilmasi "totalCartCost" toplam fiyati degistirecektir...

    public void addToCart(CartItem formal_item) {
        for (CartItem ci : items) {
            if (ci.getItem().equals(formal_item.getItem())) {
                ci.setQuantity(ci.getQuantity() + formal_item.getQuantity());    // miktar güncellemesi
                calculateTotalCartCost();
            }
        }
        this.items.add(formal_item);
        calculateTotalCartCost();
    }


    // Return tipi void olan calculateTotalCartCost() methodu tanimlayin...
    // Bu method cagirildiginda, sepete eklenen tum urunlerin adet bilgilerine gore toplam sepet fiyatini "totalCartCost" hesaplasin...
    // Instance degisken olarak tanimladigimiz "totalCartCost" degiskenini guncelleyeceksiniz...
    // addToCart() methodu icerisinde bu methodu cagirmalisiniz ki her urun eklendiginde veya miktar degistiginde toplam fiyat guncellensin...

    public void calculateTotalCartCost(){
        this.totalCartCost = 0;
        for (CartItem ci: items) {
            totalCartCost = totalCartCost + ci.getQuantity() * ci.getItem().getPrice();
        }


    }

    // Return tipi void olan emptyCart() isimli bir method tanimlayin...
    // Bu method cagirildiginda, "items" olarak tanimladiginiz List icerindeki -sepetinizdeki- urunleri silsin-temizlesin-bosaltsin...

    public void emptyCart(){
        this.items.clear();
    }


    //----------------------Getter and Setter ---------------------------------------------------------------------


    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getTotalCartCost() {
        return totalCartCost;
    }

    public void setTotalCartCost(double totalCartCost) {
        this.totalCartCost = totalCartCost;
    }
}
