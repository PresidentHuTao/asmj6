package com.example.asmj6.controller;

import com.example.asmj6.entity.Product;
import com.example.asmj6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductService ps;

    @RequestMapping("/product/list")
    public String list(Model model, @RequestParam("cid") Optional<String> cid) {
        //cid tồn tại (đã chọn 1 danh mục nào đó) thì hiển thị sp của dm đó
        //bằng ko thì hiển thị toàn bộ
        if (cid.isPresent()) {
            //trong optional thì phải có get() mới lấy ra kq được
            List<Product> list = ps.findByCategoryId(cid.get());
            model.addAttribute("items", list);
        } else {
            List<Product> list = ps.findAll();
            model.addAttribute("items", list);
        }
        return "product/list";
    }

    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Product product = ps.findById(id);
        model.addAttribute("item", product);
        return "product/detail";
    }
}
