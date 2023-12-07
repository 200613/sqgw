package com.example.demo.hcontroller;

import com.example.demo.pojo.Comment;
import com.example.demo.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping(value = "/hcomment")
public class HCommentController {

    @Autowired
    private ICommentService commentService;

    @RequestMapping("/tocomment")
    private String home(Model model, Comment comment){
        List<Comment> list=commentService.selectallComment(comment);
        model.addAttribute("commentlist", list);
        return "comment";
    }

    @RequestMapping("/deletecomment")
    private String deletecomment(Model model, Comment comment,Integer id){
        commentService.deleteComment(id);
        List<Comment> list=commentService.selectallComment(comment);
        model.addAttribute("commentlist", list);
        return "redirect:tocomment";
    }

    @RequestMapping("/toupdatecomment")
    private String toupdatecomment(Model model, Comment comment,Integer id){
        List<Comment> list=commentService.selectallComment(comment);
        model.addAttribute("comment", commentService.selectCommentById(id));
        return "updatecomment";
    }


    @RequestMapping("/viewreply")
    private String viewreply(Model model, Comment comment,Integer id,String reply) throws UnsupportedEncodingException{
        comment.setComment_reply(reply);
        comment.setId(id);
        comment.setComment_status(1);
        commentService.updateComment(comment);
        List<Comment> list=commentService.selectallComment(comment);
        model.addAttribute("commentlist", list);
        return "comment";
    }
}
