/**
 *
 */
package com.example.demo.controller;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.Cform;
import com.example.demo.pojo.Order;
import com.example.demo.service.ICommentService;
import com.example.demo.service.ICformService;
import com.example.demo.service.IOrderService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private ICommentService commentService;

    @Resource
    private ICformService cformService;

    @Resource
    private IOrderService orderService;

    @RequestMapping("/selectCommentBybid")
    public void viewcomment(HttpServletResponse response, Model model, Comment comment, Integer bid)
            throws IOException {
        List<Comment> commentlist = commentService.selectCommentBusiness(bid);
        Gson gson = new Gson();
        String json = gson.toJson(commentlist);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setContentType("text/json,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
    }

    @RequestMapping("/selectCommentBusinessBybid")
    public void selectCommentBusinessBybid(HttpServletResponse response, Model model, Comment comment, Integer bid)
            throws IOException {
        List<Comment> commentlist = commentService.selectCommentBusinessBybid(bid);
        Gson gson = new Gson();
        String json = gson.toJson(commentlist);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setContentType("text/json,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
    }

    @RequestMapping("/selectAllCommentBusiness")
    public void selectAllCommentBusiness(HttpServletResponse response, Model model, Comment comment)
            throws IOException {
        List<Comment> commentlist = commentService.selectallComment(comment);
        Gson gson = new Gson();
        String json = gson.toJson(commentlist);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setContentType("text/json,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
    }

    @RequestMapping("/addcomment")
    public void addcomment(HttpServletResponse response, Model model, Cform cform, Comment comment, Integer id,Integer sid,String sname,
                           String content, String oid, String headimgurl, String nickname, String openid, Order order, Integer bid)
            throws IOException {
        System.out.println("鍘昏瘎浠�");
//		nickname = new String(nickname.getBytes("iso-8859-1"), "UTF-8");
//
//		content = new String(content.getBytes("iso-8859-1"), "UTF-8");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        comment.setComment_name(nickname);
        comment.setComment_logo(headimgurl);
        comment.setComment_time(df.format(new Date()));
        comment.setComment_openid(openid);
        comment.setComment_text(content);
        comment.setComment_status(0);
        comment.setComment_bid(bid);
        comment.setComment_orderid(oid);
        comment.setSid(sid);
        comment.setSname(sname);
        commentService.addComment(comment);
        order.setId(id);
        order.setOrder_status(3);
        orderService.updateIsorderIsstatus(order);
        String g = 2 + "";
        Writer out = response.getWriter();
        out.write(g);
        out.flush();

    }

    @RequestMapping("/updateCommentBybid")
    public void updateCommentBybid(HttpServletResponse response, Model model, Comment comment, Integer id, String reply,
                                   Integer bid) throws IOException {
        // reply = new String(reply.getBytes("iso-8859-1"), "UTF-8");
        comment.setComment_reply(reply);
        comment.setId(id);
        comment.setComment_status(1);
        commentService.updateComment(comment);
        List<Comment> commentlist = commentService.selectCommentBusinessBybid(bid);
        Gson gson = new Gson();
        String json = gson.toJson(commentlist);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setContentType("text/json,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
    }


    @RequestMapping("/deleteCommentBybid")
    public void deleteCommentBybid(HttpServletResponse response, Model model, Comment comment, Integer id)
            throws IOException {
        commentService.deleteComment(id);
        List<Comment> commentlist = commentService.selectallComment(comment);
        Gson gson = new Gson();
        String json = gson.toJson(commentlist);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setContentType("text/json,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
    }

}
