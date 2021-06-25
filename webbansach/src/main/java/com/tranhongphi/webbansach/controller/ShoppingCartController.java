package com.tranhongphi.webbansach.controller;

import com.tranhongphi.webbansach.model.Item;
import com.tranhongphi.webbansach.model.Order;
import com.tranhongphi.webbansach.model.SanPham;
import com.tranhongphi.webbansach.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartController {
    @Autowired
    private ProductService productService;
    @GetMapping("/shopping-cart")
    public String GetShopingCart1() {return "user/shopping-cart";}
    @GetMapping("/add-cart")
    public String GetShopingCart(@Param("id") String id, @Param("soLuong") String soLuong, HttpSession session, Model model) {
        int sl = 1;
        if(id!=null) {
            SanPham sanPham = productService.getProductById(id);
            if(sanPham!=null) {
                if(soLuong!=null) {
                    sl = Integer.parseInt(soLuong);
                }
                if(session.getAttribute("order")==null) {
                    int sum = 0;
                    Order order = new Order();
                    List<Item> itemList = new ArrayList<>();
                    Item item = new Item();
                    item.setSoLuong(sl);
                    item.setSanPham(sanPham);
                    item.setGia((int)sanPham.getKhuyenMai());
                    itemList.add(item);
                    sum+= item.getGia()*item.getSoLuong();
                    order.setItems(itemList);
                    order.setTotalPrice(sum);
                    session.setAttribute("order", order);
                }else {
                    Order order = (Order) session.getAttribute("order");
                    List<Item> itemList = order.getItems();
                    boolean check = false;
                    for(Item item:itemList) {
                        if(item.getSanPham().getIdSanPham().equals(sanPham.getIdSanPham())) {
                            item.setSoLuong(item.getSoLuong()+sl);
                            order.setTotalPrice(order.getTotalPrice()+item.getGia());
                            check = true;
                        }
                    }
                    if(check==false) {
                        Item item = new Item();
                        item.setSoLuong(sl);
                        item.setSanPham(sanPham);
                        item.setGia((int) sanPham.getKhuyenMai());
                        order.setTotalPrice(order.getTotalPrice()+item.getGia());
                        itemList.add(item);
                    }
                    session.setAttribute("order", order);
                }
            }
            return "redirect:/user/index";
        }
        else {return "redirect:/user/index";}
    }
    @GetMapping("order")
    public String GetOrder(HttpSession session, Model model) {
        if(session.getAttribute("order")!=null) {
            model.addAttribute("messOrder", "Đơn hàng của bạn đang chờ xử lý");
            return "user/shopping-cart";
        }
        else {
            model.addAttribute("messOrder", "Bạn chưa có đơn hàng nào");
            return "user/shopping-cart";
        }
    }
    @GetMapping("/remoteItem")
    public String RemoteItem(@Param("id") String id, HttpSession session, Model model) {
        SanPham sanPham = productService.getProductById(id);
        Order order = (Order) session.getAttribute("order");
        List<Item> itemList = order.getItems();
        for(Item item:itemList) {
            if(item.getSanPham().getIdSanPham().equals(sanPham.getIdSanPham())) {
                order.setTotalPrice(order.getTotalPrice()-(item.getGia()*item.getSoLuong()));
                itemList.remove(item);
                order.setItems(itemList);
                break;
            }
        }
        session.setAttribute("order", order);
        return "redirect:/shopping-cart";
    }
    @PostMapping("/shopping-cart")
    public String PostShopingCart(HttpServletRequest request, HttpSession session, Model model) {
        String soLuong = request.getParameter("soLuong");
        int sl = 1;
        String id = session.getAttribute("idProductDetail").toString();
        if(id!=null) {
            SanPham sanPham = productService.getProductById(id);
            if(sanPham!=null) {
                if(soLuong!=null) {
                    sl = Integer.parseInt(soLuong);
                }
                if(session.getAttribute("order")==null) {
                    int sum = 0;
                    Order order = new Order();
                    List<Item> itemList = new ArrayList<>();
                    Item item = new Item();
                    item.setSoLuong(sl);
                    item.setSanPham(sanPham);
                    item.setGia((int)sanPham.getGiaSanPham());
                    itemList.add(item);
                    sum+= item.getGia()*item.getSoLuong();
                    order.setItems(itemList);
                    order.setTotalPrice(sum);
                    session.setAttribute("order", order);
                }else {
                    Order order = (Order) session.getAttribute("order");
                    List<Item> itemList = order.getItems();
                    boolean check = false;
                    for(Item item:itemList) {
                        if(item.getSanPham().getIdSanPham().equals(sanPham.getIdSanPham())) {
                            item.setSoLuong(item.getSoLuong()+sl);
                            order.setTotalPrice(order.getTotalPrice()+(item.getGia()*sl));
                            check = true;
                        }
                    }
                    if(check==false) {
                        Item item = new Item();
                        item.setSoLuong(sl);
                        item.setSanPham(sanPham);
                        item.setGia((int) sanPham.getGiaSanPham());
                        order.setTotalPrice(order.getTotalPrice()+(item.getGia()*sl));
                        itemList.add(item);
                    }
                    session.setAttribute("order", order);
                }
            }
            return "redirect:/shopping-cart";
        }
        else {return "redirect:/shopping-cart";}
    }
}
