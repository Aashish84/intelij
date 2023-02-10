package com.asis.blog.helper;

import com.asis.blog.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListRemoveHelper {
    public void removeFromList(Long id , List<Comment> comments){
//        for(Comment c : comments) {
//            System.out.println(c.getId());
//        }
        Comment comment=null;
        for (int i = 0 ; i < comments.size() ; i++){
//            if(!comments.get(i).getId().equals(id)){ /* line will delete data but brings error while deleting association*/
            if(comments.get(i).getId().equals(id)){
                comment = comments.get(i);
            }
        }
        comments.remove(comment);
//        System.out.println("===========");
//        for(Comment c : comments) {
//            System.out.println(c.getId());
//        }
//        return comments;
    }

//    public List<Comment> removeFromList(Long id , List<Comment> comments){
//        for(Comment c : comments) {
//            System.out.println(c.getId());
//        }
//        for (int i = 0; i < comments.size(); i++) {
//            if (Objects.equals(comments.get(i).getId(), id)) {
//                comments.remove(i);
//            }
//        }
//        for(Comment c : comments) {
//            System.out.println(c.getId());
//        }
//        return comments;
//    }
}
