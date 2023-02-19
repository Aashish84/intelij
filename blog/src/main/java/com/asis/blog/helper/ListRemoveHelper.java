package com.asis.blog.helper;

import com.asis.blog.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListRemoveHelper {
    public void removeFromList(Long id , List<Comment> comments){
        Comment comment=null;
        for (int i = 0 ; i < comments.size() ; i++){
            if(comments.get(i).getId().equals(id)){
                comment = comments.get(i);
            }
        }
        comments.remove(comment);
    }
}
