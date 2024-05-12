# On-Line_Chatting_App
## ▶ 안드로이드 스튜디오 화상 채팅앱 만들기 (Kotlin)
 
 - 안드로이드 스튜디오에서 Kotlin을 기반으로 화상 채팅(통화)을 구현하는 프로젝트

`DataBinding` `Firebase` `Firestore Database`

## 1. Co-Development Environment   
### 1. 1 Environments
- Windows 10
- Android Studio / Kotlin 
- Firebase
- GitHub

### 1. 2 Implement
- 구글 로그인을 통한 User 이메일 출력
- User 이메일을 터치하여 화상 채팅 수행

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
- 메인화면 결과


- 영상통화 화면
