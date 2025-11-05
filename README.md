This is a forum backend project.

```
forum
├─ .DS_Store
├─ .dockerignore
├─ .mvn
│  └─ wrapper
│     └─ maven-wrapper.properties
├─ Dockerfile
├─ README.md
├─ gitHistory.txt
├─ mvnw
├─ mvnw.cmd
├─ pom.xml
└─ src
   ├─ .DS_Store
   ├─ main
   │  ├─ .DS_Store
   │  ├─ java
   │  │  ├─ .DS_Store
   │  │  └─ com
   │  │     ├─ .DS_Store
   │  │     └─ forum
   │  │        ├─ .DS_Store
   │  │        └─ forum
   │  │           ├─ .DS_Store
   │  │           ├─ ForumApplication.java
   │  │           ├─ controller
   │  │           │  ├─ CommentController.java
   │  │           │  ├─ PostController.java
   │  │           │  └─ UserController.java
   │  │           ├─ dto
   │  │           │  ├─ .DS_Store
   │  │           │  ├─ ApiResponse.java
   │  │           │  ├─ CreateCommentRequest.java
   │  │           │  ├─ CreatePostRequest.java
   │  │           │  ├─ DeleteCommentRequest.java
   │  │           │  ├─ DeletePostRequest.java
   │  │           │  ├─ LoginResponse.java
   │  │           │  ├─ RegisterResponse.java
   │  │           │  ├─ UserLoginRequest.java
   │  │           │  ├─ UserRegisterRequest.java
   │  │           │  └─ resultcode
   │  │           │     ├─ AuthCode.java
   │  │           │     ├─ RegistrationCode.java
   │  │           │     └─ ResultCode.java
   │  │           ├─ entity
   │  │           │  ├─ Comment.java
   │  │           │  ├─ Post.java
   │  │           │  └─ User.java
   │  │           ├─ repository
   │  │           │  ├─ CommentRepository.java
   │  │           │  ├─ PostRepository.java
   │  │           │  └─ UserRepository.java
   │  │           └─ service
   │  │              ├─ CommentService.java
   │  │              ├─ PostService.java
   │  │              └─ UserService.java
   │  └─ resources
   │     ├─ .DS_Store
   │     ├─ application-dev.properties
   │     ├─ application-prod.properties
   │     └─ application.properties
   └─ test
      └─ java
         └─ com
            └─ forum
               └─ forum
                  └─ ForumApplicationTests.java

```