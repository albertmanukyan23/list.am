package com.example.listam.controller;

import com.example.listam.entity.Category;
import com.example.listam.entity.Comment;
import com.example.listam.entity.Item;
import com.example.listam.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/comments/add")
    public String categoryAdd(@RequestParam(name = "comment") String comm,
                              @RequestParam(name = "item") Item item, ModelMap modelMap) {
        Comment comment = new Comment();
        comment.setComment(comm);
        comment.setItem(item);
        commentRepository.save(comment);
        modelMap.addAttribute("comment", comment);

        return "redirect:/items/" + item.getId();
    }
}
