import React from "react";

function CommentCard({comment, onDeleteClick ,commentEmail}) {
    return (
        <div className="card mt-3">
            <div className="card-body">
                <p>
                    {comment.body}
                </p>
                <p>
                 From : <u>{commentEmail}</u>
                </p>

                <button className="btn btn-danger" onClick={onDeleteClick}>Delete</button>
            </div>
        </div>
    );
}

export default CommentCard;
