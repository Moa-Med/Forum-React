import React from "react";
import CommentsApi from "../../api/CommentsApi";
import PostsApi from "./../../api/PostsApi";
import CommentCard from "./CommentCard";
import CommentForm from "./CommentForm";


class CommentsPage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            comments : [],
            posts : [],
            postId : '',
        };
    }

    async createComment(commentData , postId) {
        try {
            const response = await CommentsApi.createComment(commentData , postId);
            const comment = response.data;
            const newComments = this.state.comments.concat(comment);

            this.setState({
                comments: newComments,
            });
        } catch (e) {
            console.error(e);
        }
    }

    async deleteComment(comment) {
        try {
            await CommentsApi.deleteComment(comment.id);
            const newComments = this.state.posts.filter(c => c.id !== comment.id);
            this.setState({
                comments: newComments,
            });
        } catch (e) {
            console.error(e);
        }
    }

    componentDidMount() {

        PostsApi.getAllPosts()
        .then(({data}) => this.setState({posts: data}))
        .catch(err => console.error(err));

       // this.setState({postId : this.props.postView[0].id });

    //    CommentsApi.getAllCommentsByPost()
   //         .then(({data}) => this.setState({comments: data}))
    //        .catch(err => console.error(err));
    }

    render() {
      const comments = this.state.comments;
      const id = Number(this.props.match.params.id);
      let postBody = '';
      this.state.posts.map(post => { if(post.id === id){
          postBody = post.body
        }
      });
      
        return (
            <div>
                <div className="card mt-3">
                     <div className="card-body">
                        <h5>Post number : {id}</h5>  
                        <p> {postBody} </p>
                     </div>
                 </div>
                 <br/>
            <CommentForm onSubmit={(commentData) => this.createComment(commentData , id)}/>

              { /** 
                <CommentForm onSubmit={(commentData) => this.createComment(commentData , id)}/>

                {comments.map(comment => 
                <CommentCard key={comments.id} comment={comment} onDeleteClick={() => this.deleteComment(comment.id)}/>
                )}
                */}
            </div>
        );
    }
}

export default CommentsPage;