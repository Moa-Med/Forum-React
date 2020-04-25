import Api from "./Api";

class PostsApi {

    getEmail(){
        return Api.get('/posts/email');
    }

    getAllPosts() {
        return Api.get('/posts');
    }

    getPostById(id) {
        return Api.get('/posts/'+id);
    }

    createPost(post , email){
       return Api.post('/posts/'+email, post);
    }

    createPostOld(post) {
        return Api.post('/posts', post);
    }

    updatePost(post) {
        return Api.put('/posts', post);
    }

    deletePost(id) {
        return Api.delete('/posts/'+id);
    } 
}

export default new PostsApi();