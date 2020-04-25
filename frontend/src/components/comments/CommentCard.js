import React from "react";

function CommentCard({comment, onDeleteClick ,currentEmail}) {
    return (
        <div className="card mt-3">
            <div className="card-body">
                <p>
                    {comment.body}
                </p>
                <p>
                 From : <u>{comment.user.email}</u>
                </p>
                {(comment.user.email === currentEmail) ? 
                <button className="btn btn-danger" onClick={onDeleteClick}>Delete</button> : null
                }
                
            </div>
        </div>
    );
}

export default CommentCard;
