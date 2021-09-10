# Java_Web_bbs

## 数据库

### classify
| 字段       | 类型    | 说明                |
| ---------- | ------- | ------------------- |
| classifyId | int     | 主键，Auto increase |
| name       | varchar | 分类名称            |

### forum
| 字段         | 类型     | 说明     |
| ------------ | -------- | -------- |
| name         | varchar  | 论坛名称 |
| introduction | varchar  | 论坛简介 |
| createDate   | datetime | 建站时间 |

### manager
| 字段      | 类型 | 说明                              |
| --------- | ---- | --------------------------------- |
| managerId | int  | 主键，Auto increase               |
| userId    | int  | 外键，用户id                      |
| level     | int  | 管理员级别(0:版主，1:管理员)      |
| sectionId | int  | 外键，管理的版块id(为0则全部版块) |

### posts
| 字段      | 类型     | 说明                |
| --------- | -------- | ------------------- |
| postId    | int      | 主键，Auto increase |
| sectionId | int      | 外键，所属的版块id  |
| userId    | int      | 外键，发帖人id      |
| time      | datetime | 发送时间            |
| title     | varchar  | 帖子标题            |
| content   | varchar  | 帖子内容            |

### reply
| 字段      | 类型     | 说明                       |
| --------- | -------- | -------------------------- |
| replyId   | int      | 主键，Auto increase        |
| postId    | int      | 外键，回复的帖子的id       |
| userId    | int      | 外键，回复人的id           |
| content   | varchar  | 回复内容                   |
| time      | datetime | 回复时间                   |
| isReply   | int      | 是否是回复其他评论(0否1是) |
| toReplyId | int      | 回复的评论id,可空          |

### section
| 字段       | 类型    | 说明                |
| ---------- | ------- | ------------------- |
| sectionId  | int     | 主键，Auto increase |
| name       | varchar | 版块名称            |
| classifyId | int     | 外键，所属分类id    |

### users 

| 字段      | 类型     | 说明                |
| --------- | -------- | ------------------- |
| userId    | int      | 主键，Auto increase |
| nickname  | varchar  | 用户昵称            |
| email     | varchar  | 用户邮箱            |
| passwd    | varchar  | 密码                |
| signature | varchar  | 个性签名            |
| picture   | varchar  | 头像图片路径        |
| regTime   | datetime | 注册时间            |

