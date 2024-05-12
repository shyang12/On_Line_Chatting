# On-Line_Chatting_App
## ▶ 안드로이드 스튜디오 화상 채팅앱 만들기 (Kotlin)
 
 - 안드로이드 스튜디오에서 Kotlin을 기반으로 화상 채팅(통화)을 구현하는 프로젝트

`DataBinding` `Firebase` `Firestore Database` `Remotemonster`

### WARNING!!
- 현제 Remotemonster 서비스를 카카오에서 중지하여 실행 불가!!

## 1. Co-Development Environment   
### 1. 1 Environments
- Windows 10
- Android Studio / Kotlin 
- Firebase
- GitHub

### 1. 2 Implement
- 구글 로그인을 통한 User 이메일 출력 `Firebase Authentication + Firestore Database`
- User 이메일을 터치하여 화상 채팅 수행 `Remotemonster`
- Alert를 통해 채팅방 참여 여부 결정
- Random값 (100 ~ 1000000)까지의 채널을 만들어 화상 통화방이 겹치는 것 방지

## 2. Project Architecture   
```bash
├── main
│   ├── MainActivity.kt
│   ├── LoginActivity.kt
│   ├── UserDTO.kt
│   └── VideoActivity.kt
├── ui
│   ├── layout
│   │   ├── item_person.xml
│   │   ├── activity_video.xml
│   │   ├── activity_login.xml
│   │   └── activity_main.xml
```

## 3. Firebase   
### 3.1 Authentication

### 3.2 Firestore Database
```bash
├── users
│    ├── channel
│    └── email

```

## 4. Result
- 로그인 화면
  
![로그인 전](https://github.com/shyang12/On_Line_Chatting/assets/85710913/491bb610-74ce-4ac2-a667-d9b324638eb2)

- 메인화면 결과

![로그인 후](https://github.com/shyang12/On_Line_Chatting/assets/85710913/bf05344c-6998-4a9b-8eac-e15a954d635d)

![참여 여부](https://github.com/shyang12/On_Line_Chatting/assets/85710913/1decd4f0-75d2-402b-bd5c-31ac128af656)



- 영상통화 화면

![영상 통화2](https://github.com/shyang12/On_Line_Chatting/assets/85710913/916055a3-d6cd-4f22-9086-9dc7fe3967f4)
  
