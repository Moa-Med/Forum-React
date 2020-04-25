import React from "react";
import { Link } from 'react-router-dom'

function PostCard({post, onDeleteClick}) {
    const id = post.id;
    return (
        <div className="card mt-3">
            <div className="card-body">
                <p>
                    {post.body}
                </p>
                <p>
                 From : <u>{post.user.email}</u>
                </p>

                <button className="btn btn-danger" onClick={onDeleteClick}>Delete</button>
                {' '}
                <Link to={'/posts/' + id}>
                <button className="btn btn-primary" >View</button>
                </Link>

            </div>
        </div>
    );
}

export default PostCard;