package bbs.entity;

public class Reply {
    private int replyId;
    private int postId;
    private int userId;
    private String content;
    private String time;
    private int isReply;
    private int toReplyId;

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIsReply() {
        return isReply;
    }

    public void setIsReply(int isReply) {
        this.isReply = isReply;
    }

    public int getToReplyId() {
        return toReplyId;
    }

    public void setToReplyId(int toReplyId) {
        this.toReplyId = toReplyId;
    }
}
