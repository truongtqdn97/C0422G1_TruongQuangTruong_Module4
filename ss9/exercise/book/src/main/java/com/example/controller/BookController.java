package com.example.controller;

import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping(value = "/")
    public String viewList(Model model,
                           @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("bookList", this.iBookService.findAll(pageable));
        return "list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(@PathVariable int id,
                         Model model) {
        model.addAttribute("book", this.iBookService.findById(id));
        return "detail";
    }

    @PostMapping(value = "/rent")
    public String rent(@RequestParam int rentId,
                       RedirectAttributes redirectAttributes) throws Exception {
        Book book = this.iBookService.findById(rentId);
        if (book.getQuantity() <= 0) {
            throw new Exception();
        } else {
            book.setQuantity(book.getQuantity() - 1);
            this.iBookService.save(book);
            redirectAttributes.addFlashAttribute("msg", "Cho thuê thành công!");
            return "redirect:/";
        }
    }

    @GetMapping(value = "/back/{id}")
    public String viewBack(@PathVariable int id,
                           Model model) {
        model.addAttribute("book", this.iBookService.findById(id));
        return "back";
    }

    @PostMapping(value = "/back")
    public String back(@RequestParam int backId,
                       RedirectAttributes redirectAttributes) throws Exception {
        Book book = this.iBookService.findById(backId);
        if (book.getQuantity() == book.getStock()) {
            throw new Exception();
        } else {
            book.setQuantity(book.getQuantity() + 1);
            this.iBookService.save(book);
            redirectAttributes.addFlashAttribute("msg", "Trả lại thành công!");
            return "redirect:/";
        }
    }

    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "error";
    }
}
