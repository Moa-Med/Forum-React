import Api from "./Api";

class CommentsApi {

    getAllCommentsByPost(postId) {
        return Api.get('posts/'+postId+'/comments');
    }

    getCommentById(postId,id) {
        return Api.get('posts/'+postId+'/comments/'+id);
    }

    createComment(comment , postId) {
        return Api.post('posts/'+postId+'/comments', comment);
    }

    updateComment(id) {
        return Api.put('posts/comments'+id);
    }

    deleteComment(id) {
        return Api.delete('posts/comments/'+id);
    } 
}

export default new CommentsApi();